# Android-Package-Usage-Statistics
Helps to check time app is used by user, get know app launch count and other. Root required.

# More info can be found here
http://jhshi.me/2014/04/02/get-package-usage-statistics-in-android/

# It's a built-in all android devices feature. To test it..
+ In your default dialer, type *#*#4636#*#*. It would open a window named Testing which is a sub-setting of Settings app.
+ Go to Usage Statistics.

or use ADB
+ For Android Lollipop: ```bash adb shell am start -n com.android.settings/.UsageStatsActivity```
+ For Android 4.2.1 to 4.4.2: ```bash adb shell am start -n com.android.settings/.UsageStats```

More info here: http://android.stackexchange.com/a/116633
