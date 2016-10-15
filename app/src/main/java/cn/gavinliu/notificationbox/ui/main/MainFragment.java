package cn.gavinliu.notificationbox.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Gavin on 2016/10/11.
 */

public class MainFragment extends Fragment implements MainContract.View {

    public static MainFragment newInstance() {
        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }
}
