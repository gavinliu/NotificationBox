package cn.gavinliu.notificationbox.ui.main;

import android.content.pm.PackageManager;

import java.util.List;

import cn.gavinliu.notificationbox.model.AppInfo;
import cn.gavinliu.notificationbox.utils.PackageUtils;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Gavin on 2016/10/12.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    private CompositeSubscription mSubscriptions;

    public MainPresenter(MainContract.View view) {
        mView = view;

        mSubscriptions = new CompositeSubscription();
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void startLoad(PackageManager pm) {
        mView.showProgress(true);

        Subscription subscription = PackageUtils.getAppDbList(pm)
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
                    public void onNext(List<AppInfo> appInfos) {
                        mView.showProgress(false);
                        mView.showApp(appInfos);
                    }
                });

        mSubscriptions.add(subscription);
    }

    @Override
    public void openDetail(AppInfo app) {
        mView.showDetail(app.getAppName(), app.getPackageName());
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mSubscriptions.unsubscribe();
    }

    @Override
    public void addApp() {
        mView.showAppList();
    }
}
