package cn.gavinliu.notificationbox.ui.main;

import android.content.pm.PackageManager;

import java.util.List;

import cn.gavinliu.notificationbox.model.AppInfo;
import cn.gavinliu.notificationbox.ui.BasePresenter;
import cn.gavinliu.notificationbox.ui.BaseView;

/**
 * Created by Gavin on 2016/10/11.
 */

public interface MainContract {

    interface Presenter extends BasePresenter {

        void addApp();

        void openDetail(AppInfo app);

        void startLoad(PackageManager pm);
    }

    interface View extends BaseView<Presenter> {

        void showProgress(boolean isShown);

        void showEmpty();

        void showApp(List<AppInfo> apps);

        void showAppList();

        void showDetail(String appName, String packageName);
    }

}
