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