package cn.gavinliu.notificationbox.utils;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.gavinliu.notificationbox.model.AppInfo;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Gavin on 16-10-18.
 */

public class PackageUtils {

    public static Observable<List<AppInfo>> getInstallPackages(final PackageManager pm) {
        return Observable.create(new Observable.OnSubscribe<List<AppInfo>>() {
            @Override
            public void call(Subscriber<? super List<AppInfo>> subscriber) {
                List<AppInfo> appInfos = new ArrayList<>();

                Intent intent = new Intent();
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setAction(Intent.ACTION_MAIN);
                List<ResolveInfo> resolveInfoList = pm.queryIntentActivities(intent, 0);

                for (ResolveInfo info : resolveInfoList) {
                    AppInfo app = new AppInfo();
                    app.setIcon(info.loadIcon(pm));
                    app.setAppName(info.loadLabel(pm).toString());
                    app.setPackageName(info.activityInfo.packageName);

                    appInfos.add(app);
                }

                List<AppInfo> db = DbUtils.getApp();
                List<AppInfo> temp = new ArrayList<>();

                for (AppInfo info : appInfos) {
                    for (AppInfo a : db) {
                        if (a.getPackageName().equals(info.getPackageName())) {
                            info.setSelect(true);
                            temp.add(info);
                        }
                    }
                }

                appInfos.removeAll(temp);
                appInfos.addAll(0, temp);

                subscriber.onNext(appInfos);
            }
        });
    }

    public static Observable<List<AppInfo>> getAppDbList(final PackageManager pm) {
        return Observable.create(new Observable.OnSubscribe<List<AppInfo>>() {

            @Override
            public void call(Subscriber<? super List<AppInfo>> subscriber) {
                List<AppInfo> appInfos = new ArrayList<>();


                List<AppInfo> db = DbUtils.getApp();

                Intent intent = new Intent();
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setAction(Intent.ACTION_MAIN);
                List<ResolveInfo> resolveInfoList = pm.queryIntentActivities(intent, 0);

                for (ResolveInfo info : resolveInfoList) {
                    for (AppInfo app : db) {
                        if (info.activityInfo.packageName.equals(app.getPackageName())) {
                            app.setIcon(info.loadIcon(pm));

                            appInfos.add(app);
                        }
                    }
                }

                subscriber.onNext(appInfos);
            }
        });
    }

}
