package cn.gavinliu.notificationbox.utils;

import java.util.List;

import cn.gavinliu.notificationbox.NotificationBoxApp;
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

}
