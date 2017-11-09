:warning: Work in progress :warning:

# react-native-batch
React Native integration of the Batch.com SDK

# Aim
The aim of this project is to provide a high quality, easy to use, full integration of the [Batch](https://batch.com/) SDK for react-native for Android and iOS.

Contributions welcome.


## Getting started

`$ npm install react-native-batch --save`

### Mostly automatic installation

`$ react-native link react-native-batch`

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

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNBatch.sln` in `node_modules/react-native-batch/windows/RNBatch.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Batch.RNBatch;` to the usings at the top of the file
  - Add `new RNBatchPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNBatch from 'react-native-batch';

// TODO: What to do with the module?
RNBatch;
```

# Contributing

## Roadmap
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
