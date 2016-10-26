package cn.gavinliu.notificationbox.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.preference.PreferenceManager;

import cn.gavinliu.notificationbox.NotificationBoxApp;

/**
 * Created by Gavin on 16-10-26.
 */

public class SettingUtils {

    private static SettingUtils util;
    private SharedPreferences mPreference;

    private synchronized static void createInstance(Context ctx) {
        if (util == null) {
            util = new SettingUtils(ctx);
        }
    }

    public static SettingUtils getInstance() {
        if (util == null) {
            createInstance(NotificationBoxApp.get());
        }
        return util;
    }

    private SettingUtils(Context ctx) {
        mPreference = PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public boolean isNotify() {
        return mPreference.getBoolean("isNotify", false);
    }
}
