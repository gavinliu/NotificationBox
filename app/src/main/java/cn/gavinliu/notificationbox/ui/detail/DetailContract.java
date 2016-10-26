package cn.gavinliu.notificationbox.ui.detail;

import java.util.List;

import cn.gavinliu.notificationbox.model.NotificationInfo;
import cn.gavinliu.notificationbox.ui.BasePresenter;
import cn.gavinliu.notificationbox.ui.BaseView;

/**
 * Created by Gavin on 16-10-17.
 */

public interface DetailContract {

    interface Presenter extends BasePresenter {

        void startLoad(String packageName);

    }

    interface View extends BaseView<Presenter> {

        void showProgress(boolean isShown);

        void showEmpty();

        void showNotifications(List<NotificationInfo> notifications);
    }
}
