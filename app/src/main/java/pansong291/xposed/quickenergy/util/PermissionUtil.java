package pansong291.xposed.quickenergy.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import pansong291.xposed.quickenergy.hook.AntForestRpcCall;

public class PermissionUtil {
    private static final String TAG = AntForestRpcCall.class.getCanonicalName();

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    private static final String[] PERMISSIONS_STORAGE = {
            "android.permission.WRITE_EXTERNAL_STORAGE",
    };

    public static boolean checkPermissions(Context context) {
        for (String permission : PERMISSIONS_STORAGE) {
            if (context.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public static void requestPermissions(Activity activity) {
        try {
            if (!checkPermissions(activity)) {
                activity.requestPermissions(PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            Log.printStackTrace(TAG, e);
        }
    }
}
