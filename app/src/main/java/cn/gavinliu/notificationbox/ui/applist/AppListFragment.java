package cn.gavinliu.notificationbox.ui.applist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.gavinliu.notificationbox.R;
import cn.gavinliu.notificationbox.ui.main.MainContract;

/**
 * Created by Gavin on 16-10-17.
 */

public class AppListFragment extends Fragment implements AppListContract.View {

    public static AppListFragment newInstance() {
        AppListFragment fragment = new AppListFragment();
        return fragment;
    }

    private View mView;

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_applist, null, false);
        }
        return mView;
    }
}
