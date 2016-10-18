package cn.gavinliu.notificationbox.ui.applist;

import android.content.pm.PackageManager;

import java.util.List;

import cn.gavinliu.notificationbox.model.AppInfo;
import cn.gavinliu.notificationbox.ui.BasePresenter;
import cn.gavinliu.notificationbox.ui.BaseView;

/**
 * Created by Gavin on 16-10-17.
 */

public interface AppListContract {

    interface Presenter extends BasePresenter {

        void startLoad(PackageManager pm);
    }

    interface View extends BaseView<Presenter> {

        void showAppList(List<AppInfo> appList);
    }
}
