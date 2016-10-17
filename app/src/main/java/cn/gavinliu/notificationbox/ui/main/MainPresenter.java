package cn.gavinliu.notificationbox.ui.main;

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
