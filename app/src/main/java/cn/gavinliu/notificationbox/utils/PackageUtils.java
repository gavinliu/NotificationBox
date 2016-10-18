package cn.gavinliu.notificationbox.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

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

                List<PackageInfo> mPacks = pm.getInstalledPackages(0);
                for (PackageInfo info : mPacks) {
                    if ((info.applicationInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) == 0) {
                        AppInfo app = new AppInfo();

                        app.setIcon(info.applicationInfo.loadIcon(pm));
                        app.setAppName(info.applicationInfo.loadLabel(pm).toString());
                        app.setPackageName(info.packageName);

                        appInfos.add(app);
                    }
                }

                subscriber.onNext(appInfos);
            }
        });
    }
}
