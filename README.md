# react-native-batch
React Native integration of the [Batch](https://batch.com/) SDK for Android and iOS.

# Roadmap
1. :ballot_box_with_check: Initialize SDK 
1. :ballot_box_with_check: Configure push notifications 
1. :ballot_box_with_check: Custom User IDs
1. :ballot_box_with_check: Deep linking
1. :ballot_box_with_check: Rich notifications (you still need to do some manual integration, actions not supported yet)
1. :ballot_box_with_check: Location
1. :ballot_box_with_check: Tracking Events
1. :ballot_box_with_check: Mobile Landing (with some limitations)
1. :ballot_box_with_check: In App messaging (with some limitations)
1. Todo: Inbox support
1. Todo: Attributes support 
1. Todo: Tracking Transactions 
1. Todo: Write tests
1. Todo: Add linting to help contributors
1. ...

Contributions welcome.

Credit: The push notification parts of this project is based on [bamlab's react-native-batch-push package](https://github.com/bamlab/react-native-batch-push)

## Getting started

`yarn add react-native-batch`

Issues? See the Manual installation section.

## Usage
```javascript
import Batch from 'react-native-batch';

Batch.registerForRemoteNotifications();
```

See [full reference](https://github.com/dangerfarms/react-native-batch/blob/master/docs/reference.md).

## Manual installation

Using the installation methods in Getting started section is highly recommended. 

However if you run into issues, this section should help troubleshooting.


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-batch` and add `RNBatch.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNBatch.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.dangerfarms.reactnative.batch.RNBatchPackage;` to the imports at the top of the file
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

## SDK integration and push notification setup 

See [push setup docs](https://github.com/dangerfarms/react-native-batch/blob/master/docs/push-setup.md).

## Location tracking

See [location tracking setup docs](https://github.com/dangerfarms/react-native-batch/blob/master/docs/location-tracking.md)

## Contributing

All PRs welcome.  
The project is still on progress, so there are no tests, and no linting in place.

