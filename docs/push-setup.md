# Push notifications

## Setup

Bear with me...

### Android push notification setup

- Go to the Batch dashboard, create an Android app and setup your GCM configuration.
- Follow the instructions in the [Batch integration prerequisite docs](https://batch.com/doc/android/prerequisites.html).
- In `android/app/build.gradle`, provide in your config:
    ```
    defaultConfig {
      ...
      resValue "string", "GCM_SENDER_ID", "%YOUR_GCM_SENDER_ID%"
      resValue "string", "BATCH_API_KEY_DEV", "%YOUR_BATCH_DEV_API_KEY%"
      resValue "string", "BATCH_API_KEY_PROD", "%YOUR_BATCH_PROD_API_KEY%"
    }
    ```
  
### iOS push notification setup

- Go to the Batch dashboard, create an iOS app
- [Create a Push notification certificate and upload it to Batch.](https://batch.com/doc/ios/prerequisites.html) 
- Download the [Batch SDK](https://batch.com/download#/iOS)
  - **unzip and move the `Batch.embeddedframework` folder to `<your-project-root>/ios/Frameworks/`** (create this directory if doesn't exist).
  - from here, drag and drop into the Frameworks of your project.
- Add your Batch API key to Info.plist (note: make sure that your project's Build Settings includes the [DEBUG macro](https://stackoverflow.com/questions/9063100/xcode-ios-how-to-determine-whether-code-is-running-in-debug-release-build)):
    ```xml
    <dict>
        ...
        <key>BatchAPIKeyDev</key>  
        <string>%YOUR_BATCH_DEV_API_KEY%</string> <!-- Used when the app is built in development mode -->
        <key>BatchAPIKeyProd</key>  
        <string>%YOUR_BATCH_PROD_API_KEY%</string> 
    </dict>
    ```
- Enable the Push notification entitlement in Xcode Capabilities tab
- Call `registerForRemoteNotifications` from RN:
    ```js
    import Batch from '@dangerfarms/react-native-batch';
    
    Batch.registerForRemoteNotifications();
    ```

And you are ready to go!
:doughnut:
