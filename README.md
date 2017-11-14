:warning: Work in progress :warning:

# react-native-batch
React Native integration of the Batch.com SDK

# Aim
The aim of this project is to provide a high quality, easy to use, full integration of the [Batch](https://batch.com/) SDK for react-native for Android and iOS.

Contributions welcome.

(This project is based on https://github.com/bamlab/react-native-batch-push)

## Getting started

### While in heavy development

1. Clone the project
1. `yarn`
1. `npm pack`
1. Copy the resulting `.tgz` file to your project root
1. Navigate to your projects root and run `yarn add ./[zipfile name].tgz`

### In the near future

`yarn add react-native-batch`

Issues? See the Manual installation section.

## Usage
```javascript
import Batch from 'react-native-batch';

Batch.registerForRemoteNotifications();
```

## Manual installation

Using the installation methods in Getting started section is highly recommended. 

However if you run into issues, this section should help troubleshooting.


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-batch` and add `RNBatch.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNBatch.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNBatchPackage;` to the imports at the top of the file
  - Add `new RNBatchPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-batch'
  	project(':react-native-batch').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-batch/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-batch')
  	```

## Push notification setup 

### Android push notification setup

- Follow the instructions in the [Batch integration prerequisite docs](https://batch.com/doc/android/prerequisites.html).
- Add your Sender ID and API Key to `android/app/src/main/res/values/strings.xml`. It should look like this: 
```xml
<resources>
    ...
    <string name="BATCH_API_KEY">DEVXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</string> <!-- Development key -->
    <!--<string name="BATCH_API_KEY">XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</string> --><!-- Production key -->
    <string name="GCM_SENDER_ID">XXXXXXXXX</string>
</resources>
```

### iOS push notification setup

Follow the instructions in the [Batch integration docs](https://dashboard.batch.com) > your iOS app dashboard > Integrate.
- Create a Push notification certificate and upload it to Batch. <GUIDE LINK>
- Download the SDK <LINK>.
  - unzip and move the `Batch.embeddedframework` folder to `<your-project-root>/ios/Frameworks/` (create this directory if doesn't exist).
  - from here, drag and drop into the Frameworks of your project.
- Add your Batch API key to Info.plist:
```xml
<dict>
    ...
    <key>BatchAPIKey</key>  
    <string>%YOUR_BATCH_API_KEY%</string> <!-- Development key -->
    <!--<string>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</string> --><!-- Production key -->
</dict>
```
- Enable the Push notification entitlement in Xcode Capabilities tab
- Call `registerForRemoteNotifications` from RN:
```js
import Batch from 'react-native-batch';

Batch.registerForRemoteNotifications();
```

## Contributing

Soon.

### Roadmap
1. Initialize SDK
1. Configure push notifications
1. Custom User IDs 
1. Deep linking 
1. Rich notifications
1. Location
1. Tracking Events.
1. In App messaging
1. Inbox support
1. Attributes support
1. Tracking Transactions
1. ...

