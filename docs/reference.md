# Reference

## Push notifications

### `registerforRemoteNotifications()`

Required in iOS only. 

Trigger the system propmt asking for the notification permission.

## Custom userIds

### `login(userId)`
Set the custom userID attribute to `userId`.

### `logout()`
Set the custom userID attribute to `null`.

This is Batch's way to log out. Equivalent to `login(null)`.

You must call `logout` when the user logs out. (Check docs for 
[ios](https://batch.com/doc/ios/custom-data/customid.html#_setting-up-a-custom-user-id), 
[android](https://batch.com/doc/android/custom-data/customid.html#_setting-up-a-custom-user-id))

### Deeplinking
Deeplinking is not strictly related to batch, you need to be able to handle deeplinks in your app, then 
you can use the Batch dashboard to send notifications with deeplinks.

Other than the Batch docs, you can gain inspiration from this article: 
https://medium.com/react-native-training/deep-linking-your-react-native-app-d87c39a1ad5e

Note that if you are using FB login, you should change the openUrl method in your `AppDelegate.m` to combine
both FB and Deeplink handling:

```objective-c
// Handle linking from both FB login and deeplinks
- (BOOL)application:(UIApplication *)application openURL:(NSURL *)url sourceApplication:(NSString *)sourceApplication annotation:(id)annotation {

  BOOL handleRCTLinking = [RCTLinkingManager application:application openURL:url
                             sourceApplication:sourceApplication annotation:annotation];

  BOOL handleFB = [[FBSDKApplicationDelegate sharedInstance] application:application
                                                        openURL:url
                                              sourceApplication:sourceApplication
                                                     annotation:annotation];
  return handleRCTLinking && handleFB;
}
```

## Location

### `trackLocation({ longitude: <Number>, latitude: <Number>, [accuracy: <Number>]})`
Set the user's location to the passed in value.  
`accuracy` is optional, and should be in meters.

Usage: 
```es2016
navigator.geolocation.getCurrentPosition(
    (position) => {
        Batch.trackLocation(position.coords);        
    },
    (error) => {
        // handle error
    }
);
```
