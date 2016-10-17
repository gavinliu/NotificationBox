package cn.gavinliu.notificationbox.ui.applist;

import cn.gavinliu.notificationbox.ui.BasePresenter;
import cn.gavinliu.notificationbox.ui.BaseView;

/**
 * Created by Gavin on 16-10-17.
 */

public interface AppListContract {

    interface Presenter extends BasePresenter {
    }

    interface View extends BaseView<Presenter> {
    }
}
