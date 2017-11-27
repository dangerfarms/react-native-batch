# Location tracking

## Setup

### Android 

Make sure you have added the location permission you would like to use to 
your Manifest file:
```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```

Then, if you don't need more granular control over when to track users, change 
your MainActivity.js to look something like this: 
```java
public class MainActivity extends ReactActivity {
    @Override
    protected void onCreate(Bundle savedInstance) {
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

            // Acquire a reference to the system Location Manager
            LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

            // Define a listener that responds to location updates
            LocationListener locationListener = new LocationListener() {
                public void onLocationChanged(Location location) {
                    // Called when a new location is found by the network location provider.
                    Batch.User.trackLocation(location);
                }

                public void onStatusChanged(String provider, int status, Bundle extras) {
                }

                public void onProviderEnabled(String provider) {
                }

                public void onProviderDisabled(String provider) {
                }
            };

            // Register the listener with the Location Manager to receive location updates
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
        
        // ...
        
        super.onCreate(savedInstance);
    }
    
    // ...

}
```

This will listen to location changes and send the location from the phone to 
Batch whenever it is updated.

If you want to send locations at certain times, or you want to be consistent 
with iOS, you can use the [react-native methods](reference.md#Location) without
any additional setup (you will need the permission defined in the Manifest 
of course).