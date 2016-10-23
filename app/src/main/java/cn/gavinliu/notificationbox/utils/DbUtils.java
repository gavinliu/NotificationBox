package cn.gavinliu.notificationbox.utils;

import com.litesuits.orm.db.assit.QueryBuilder;
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
        if (info.getTitle() == null || info.getText() == null) return;
        NotificationBoxApp.getLiteOrm().save(info);
    }

    public static List<NotificationInfo> getNotification(String packageName) {
        return NotificationBoxApp.getLiteOrm().query(new QueryBuilder<NotificationInfo>(NotificationInfo.class)
                .where("packageName = ?", packageName).orderBy("time desc"));
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
