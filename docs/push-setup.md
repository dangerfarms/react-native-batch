# Push notifications

## Setup

Bear with me...

### Android push notification setup

- Go to the Batch dashboard, create an Android app and setup your GCM configuration.
- Follow the instructions in the [Batch integration prerequisite docs](https://batch.com/doc/android/prerequisites.html).
- If you are using `react-native-config`, use the .env files to set your api key and skip the next step.
- In `android/app/build.gradle`, provide in your config:
    ```
    defaultConfig {
      ...
      resValue "string", "GCM_SENDER_ID", "%YOUR_GCM_SENDER_ID%"
      resValue "string", "BATCH_API_KEY", "%YOUR_BATCH_API_KEY%" // development
      // resValue "string", "BATCH_API_KEY", "%YOUR_BATCH_API_KEY%" // production
    }
    ```
- (Optional) Add your custom push icon in `android/app/src/main/res/drawable-<size>/push_icon.png` folders.
[More info on status icons](https://developer.android.com/guide/practices/ui_guidelines/icon_design_status_bar.html)
  
### iOS push notification setup

- Go to the Batch dashboard, create an iOS app
- [Create a Push notification certificate and upload it to Batch.](https://batch.com/doc/ios/prerequisites.html) 
- Follow the instructions to install the Batch SDK pod. (Currently only pod setup is supported.)
- If you are using `react-native-config`, use the .env files to set your api key and skip the next step.
- Add your Batch API key to Info.plist (note: make sure that your project's Build Settings includes the [DEBUG macro](https://stackoverflow.com/questions/9063100/xcode-ios-how-to-determine-whether-code-is-running-in-debug-release-build)):
    ```xml
    <dict>
        ...
        <key>BatchAPIKey</key>  
        <string>%YOUR_BATCH_API_KEY%</string>   <!-- development -->
        <!--<string>%YOUR_BATCH_API_KEY%</string> --> <!-- production -->
    </dict>
    ```
- Enable the Push notification entitlement in Xcode Capabilities tab
- Call `registerForRemoteNotifications` from RN:
    ```js
    import Batch from 'react-native-batch';
    
    Batch.registerForRemoteNotifications();
    ```

### Rich notifications
> If you don't intend to use rich notifications, you can skip this part.

**Anrdoid**  
Should work out of the box, once push notifications are set up.

**iOS**  
Follow the [Batch guide](https://batch.com/doc/ios/sdk-integration/rich-notifications-setup.html) — it's super easy!

And you are ready to go!

:doughnut:
