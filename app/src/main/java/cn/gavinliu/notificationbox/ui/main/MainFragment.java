package cn.gavinliu.notificationbox.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import cn.gavinliu.notificationbox.ui.applist.AppListActivity;

/**
 * Created by Gavin on 2016/10/11.
 */

public class MainFragment extends Fragment implements MainContract.View {

    MainContract.Presenter mPresenter;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showAppList() {
        Intent intent = new Intent(getContext(), AppListActivity.class);
        startActivityForResult(intent, 0);
    }
}
