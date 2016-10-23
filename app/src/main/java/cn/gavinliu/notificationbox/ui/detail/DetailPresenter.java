package cn.gavinliu.notificationbox.ui.detail;

import cn.gavinliu.notificationbox.utils.DbUtils;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Gavin on 16-10-17.
 */

public class DetailPresenter implements DetailContract.Presenter {

    DetailContract.View mView;

    private CompositeSubscription mSubscriptions;

    public DetailPresenter(DetailContract.View view) {
        mView = view;

        mSubscriptions = new CompositeSubscription();
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void startLoad(String packageName) {
        mView.showProgress(false);

        mView.showNotifications(DbUtils.getNotification(packageName));
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mSubscriptions.unsubscribe();
    }
}
