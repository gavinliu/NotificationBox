package cn.gavinliu.notificationbox.ui.applist;

import android.content.Intent;
import android.content.pm.PackageManager;

import java.util.List;

import cn.gavinliu.notificationbox.model.AppInfo;
import cn.gavinliu.notificationbox.utils.DbUtils;
import cn.gavinliu.notificationbox.utils.PackageUtils;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Gavin on 16-10-17.
 */

public class AppListPresenter implements AppListContract.Presenter {

    private AppListContract.View mView;

    private CompositeSubscription mSubscriptions;

    public AppListPresenter(AppListContract.View view) {
        mView = view;

        mSubscriptions = new CompositeSubscription();
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void startLoad(PackageManager pm) {
        Subscription subscription = PackageUtils.getInstallPackages(pm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<AppInfo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<AppInfo> list) {
                        mView.showAppList(list);
                    }
                });

        mSubscriptions.add(subscription);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }


    @Override
    public void saveApp(AppInfo app) {
        DbUtils.saveApp(app);
    }

    @Override
    public void deleteApp(AppInfo app) {
        DbUtils.deleteApp(app);
    }
}
