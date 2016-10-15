package cn.gavinliu.notificationbox.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.provider.Settings;
import android.text.TextUtils;

/**
 * Created by Gavin on 2016/10/12.
 */

public class CommonUtils {

    public static boolean checkNotificationReadPermission(Activity activity) {
        String notiStr = Settings.Secure.getString(activity.getContentResolver(), "enabled_notification_listeners");
        if (notiStr != null && !TextUtils.isEmpty(notiStr)) {
            final String[] names = notiStr.split(":");
            for (String name : names) {
                ComponentName cn = ComponentName.unflattenFromString(name);
                if (cn != null) {
                    return activity.getPackageName().equals(cn.getPackageName());
                }
            }
        }
        return false;
    }
}
