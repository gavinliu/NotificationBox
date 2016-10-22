package cn.gavinliu.notificationbox.utils;

import com.litesuits.orm.db.assit.WhereBuilder;

import java.util.List;

import cn.gavinliu.notificationbox.NotificationBoxApp;
import cn.gavinliu.notificationbox.model.AppInfo;
import cn.gavinliu.notificationbox.model.NotificationInfo;

/**
 * Created by Gavin on 16-10-15.
 */

public class DbUtils {

    public static void saveNotification(NotificationInfo info) {
        NotificationBoxApp.getLiteOrm().save(info);
    }

    public static List<NotificationInfo> getNotification() {
        return NotificationBoxApp.getLiteOrm().query(NotificationInfo.class);
    }

    public static void getNotification(String packageName) {
    }

    public static List<AppInfo> getApp() {
        return NotificationBoxApp.getLiteOrm().query(AppInfo.class);
    }

    public static void saveApp(AppInfo info) {
        NotificationBoxApp.getLiteOrm().save(info);
    }

    public static void deleteApp(AppInfo info) {
        NotificationBoxApp.getLiteOrm().delete(new WhereBuilder(AppInfo.class)
                .where("packageName = ?", info.getPackageName()));
    }

}
