:warning: Work in progress :warning:

# @dangerfarms/react-native-batch
React Native integration of the Batch.com SDK

# Aim
The aim of this project is to provide a high quality, easy to use, full integration of the [Batch](https://batch.com/) SDK for react-native for Android and iOS.

Contributions welcome.

(This project is based on https://github.com/bamlab/react-native-batch-push)

## Getting started

`yarn add @dangerfarms/react-native-batch`

Issues? See the Manual installation section.

## Usage
```javascript
import Batch from '@dangerfarms/react-native-batch';

Batch.registerForRemoteNotifications();
```

See [full reference](docs/reference.md).

## Manual installation

Using the installation methods in Getting started section is highly recommended. 

However if you run into issues, this section should help troubleshooting.


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `@dangerfarms/react-native-batch` and add `RNBatch.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNBatch.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNBatchPackage;` to the imports at the top of the file
  - Add `new RNBatchPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':@dangerfarms_react-native-batch'
  	project(':@dangerfarms_react-native-batch').projectDir = new File(rootProject.projectDir, 	'../node_modules/@dangerfarms/react-native-batch/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':@dangerfarms_react-native-batch')
  	```

## Push notification setup 

See [push setup docs](docs/push-setup.md).

## Contributing

Soon.

### Roadmap
1. ~~Initialize SDK~~
1. ~~Configure push notifications~~
1. Custom User IDs 
1. ~~Deep linking~~ 
1. Rich notifications
1. Location
1. Tracking Events.
1. In App messaging
1. Inbox support
1. Attributes support
1. Tracking Transactions
1. ...

