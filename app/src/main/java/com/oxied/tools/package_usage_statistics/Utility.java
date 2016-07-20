package com.oxied.tools.package_usage_statistics;

import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.internal.app.IUsageStats;
import com.android.internal.os.PkgUsageStats;

import java.lang.reflect.Method;

/**
 * Created by oxied on 7/20/16.
 */
public class Utility {

    static final String TAG = "PackageUsageStatistics";
    private static final String SERVICE_MANAGER_CLASS = "android.os.ServiceManager";
    private static final int returnNotFound = -1;

    @Nullable
    public static PkgUsageStats[] getAllPkgUsageStats() {
        IUsageStats mUsageStatsService;

        try {
            Class serviceManager = Class.forName(SERVICE_MANAGER_CLASS);
            Method getService = serviceManager.getDeclaredMethod("getService", new Class[]{String.class});
            mUsageStatsService = IUsageStats.Stub.asInterface((IBinder) getService.invoke(null, "usagestats"));
            if (mUsageStatsService == null) {
                return null;
            }

            return mUsageStatsService.getAllPkgUsageStats();
        } catch (Exception e) {
            Log.e(TAG, "Failed to get package usage stats: " + e);
        }

        return null;
    }

    public static int getAppLaunchCount(String packageName) {
        PkgUsageStats[] pkgUsageStats = getAllPkgUsageStats();
        if (pkgUsageStats == null) {
            return returnNotFound;
        }

        for (PkgUsageStats pkgUsageStat : pkgUsageStats) {
            if (0 == pkgUsageStat.packageName.compareToIgnoreCase(packageName)) { //strings are the same.
                return pkgUsageStat.launchCount;
            }
        }

        return returnNotFound;
    }

}
