:warning: Work in progress :warning:

# react-native-batch
React Native integration of the Batch.com SDK

# Aim
The aim of this project is to provide a high quality, easy to use, full integration of the [Batch](https://batch.com/) SDK for react-native for Android and iOS.

Contributions welcome.


## Getting started

### While in heavy development

1. Clone the project
1. `yarn`
1. `npm pack`
1. Copy the resulting `.tgz` file to your project root
1. Navigate to your projects root and run `yarn add ./[zipfile name].tgz`

### In the future

`yarn add react-native-batch`


### Mostly automatic installation

`react-native link react-native-batch`

### Manual installation


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

## Usage
```javascript
import RNBatch from 'react-native-batch';

// TODO: Usage will be here
RNBatch;
```

## Push notification setup 

### Android push notification setup

Follow the instructions in the [Batch integration docs](https://dashboard.batch.com) > your Android app dashboard > Integrate.

### iOS push notification setup

Follow the instructions in the [Batch integration docs](https://dashboard.batch.com) > your iOS app dashboard > Integrate.

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
