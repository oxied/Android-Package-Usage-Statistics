# Android-Package-Usage-Statistics
Hack that helps to check how long time an app was used by user, helps to get know how many times app was launched and so on. Root is required.

# For SDK v23 use native https://github.com/googlesamples/android-AppUsageStatistics

# More info can be found here
http://jhshi.me/2014/04/02/get-package-usage-statistics-in-android/

# It's a built-in all android devices feature. To test it..
+ In your default dialer, type *#*#4636#*#*. It would open a window named Testing which is a sub-setting of Settings app.
+ Go to Usage Statistics.

or use ADB
+ For Android Lollipop: ```bash adb shell am start -n com.android.settings/.UsageStatsActivity```
+ For Android 4.2.1 to 4.4.2: ```bash adb shell am start -n com.android.settings/.UsageStats```

More info here: http://android.stackexchange.com/a/116633
