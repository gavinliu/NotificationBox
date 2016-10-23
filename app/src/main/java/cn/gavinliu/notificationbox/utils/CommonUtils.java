package cn.gavinliu.notificationbox.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.provider.Settings;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

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
                    if (activity.getPackageName().equals(cn.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String getTimeStr(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return format.format(date);
    }
}
