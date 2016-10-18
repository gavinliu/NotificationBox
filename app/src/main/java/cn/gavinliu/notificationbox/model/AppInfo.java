package cn.gavinliu.notificationbox.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Gavin on 2016/10/11.
 */

public class AppInfo {

    private String packageName;

    private String appName;

    private Drawable icon;


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
