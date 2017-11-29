
package com.reactlibrary;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.batch.android.Batch;
import com.batch.android.BatchInboxFetcher;
import com.batch.android.BatchInboxNotificationContent;
import com.batch.android.Config;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

import java.util.List;
import java.util.Map;

public class RNBatchModule extends ReactContextBaseJavaModule implements LifecycleEventListener {


    private final ReactApplicationContext reactContext;
    private String batchAPIKey;

    public RNBatchModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        this.reactContext.addLifecycleEventListener(this);

        try {
            Resources resources = reactContext.getResources();
            String packageName = reactContext.getApplicationContext().getPackageName();

            this.batchAPIKey = resources.getString(resources.getIdentifier("BATCH_API_KEY", "string", packageName));

            Batch.Push.setGCMSenderId(resources.getString(resources.getIdentifier("GCM_SENDER_ID", "string", packageName)));
            Batch.setConfig(new Config(this.batchAPIKey));

            startBatch();
        } catch (Exception e) {
            Log.e("RNBatch", e.getMessage());
        }

    }

    private void startBatch() {
        Activity activity = getCurrentActivity();
        if (activity == null)
            return;

        Batch.onStart(activity);
    }

    @ReactMethod
    public void registerForRemoteNotifications() {
        // not needed on Android
        return;
    }

    @ReactMethod
    public void login(String userID) {
        Batch.User.editor()
                .setIdentifier(userID)
                .save();
    }

    @ReactMethod
    public void logout() {
        Batch.User.editor()
                .setIdentifier(null)
                .save();
    }

    @ReactMethod
    public void fetchNewNotifications(String userID, String authKey, final Promise promise) {
        try {
            BatchInboxFetcher inboxFetcher = Batch.Inbox.getFetcher(userID, authKey);
            inboxFetcher.fetchNewNotifications(new BatchInboxFetcher.OnNewNotificationsFetchedListener() {
                public void onFetchSuccess(@NonNull List<BatchInboxNotificationContent> notifications, boolean foundNewNotifications, boolean endReached) {
                    WritableArray jsNotifications = Arguments.createArray();

                    for (BatchInboxNotificationContent notification : notifications) {
                        Bundle payloadBundle = new Bundle();
                        for (Map.Entry<String, String> entry : notification.getRawPayload().entrySet()) {
                            payloadBundle.putString(entry.getKey(), entry.getValue());
                        }
                        WritableMap jsNotification = Arguments.createMap();
                        jsNotification.putMap("payload", Arguments.fromBundle(payloadBundle));
                        jsNotification.putString("title", notification.getTitle());
                        jsNotification.putString("body", notification.getBody());
                        jsNotification.putDouble("timestamp", notification.getDate().getTime());
                        jsNotifications.pushMap(jsNotification);
                    }

                    promise.resolve(jsNotifications);
                }

                public void onFetchFailure(@NonNull String error) {
                    promise.reject("BATCH_ERROR", "Error fetching new notifications: " + error);
                }
            });
        } catch (Exception exception) {
            Log.e("RNBatch", "Unknown exception: " + exception.getMessage());
        }
    }

    @ReactMethod
    public void trackLocation(ReadableMap position) {
        final Location location = new Location("RNBatch");
        location.setLongitude(position.getDouble("longitude"));
        location.setLatitude(position.getDouble("latitude"));
        location.setAccuracy((float) position.getDouble("accuracy"));

        Batch.User.trackLocation(location);
    }

    @ReactMethod
    public void trackEventWithLabel(String eventName, String label) {
        Batch.User.trackEvent(eventName, label);
    }

    @ReactMethod
    public void trackEventWithName(String eventName) {
        Batch.User.trackEvent(eventName);
    }

    @ReactMethod
    public void setMobileLandingFontOverride(ReadableMap normalFont, ReadableMap boldFont) {
        Typeface normalTypeface = Typeface.createFromAsset(this.reactContext.getAssets(), normalFont.getString("path"));
        Typeface boldTypeface = Typeface.createFromAsset(this.reactContext.getAssets(), boldFont.getString("path"));
        Batch.Messaging.setTypefaceOverride(normalTypeface, boldTypeface);
    }

    @ReactMethod
    public void resetMobileLandingFont() {
        Batch.Messaging.setTypefaceOverride(null, null);
    }

    @Override
    public void onHostResume() {
        startBatch();
    }

    @Override
    public void onHostPause() {
        Batch.onStop(getCurrentActivity());
    }

    @Override
    public void onHostDestroy() {
        Batch.onDestroy(getCurrentActivity());
    }

    @Override
    public String getName() {
        return "RNBatch";
    }
}