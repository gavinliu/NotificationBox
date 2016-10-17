package cn.gavinliu.notificationbox.ui.applist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.gavinliu.notificationbox.R;

/**
 * Created by Gavin on 16-10-17.
 */

public class AppListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applist);

        AppListFragment mainFragment = (AppListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_applist);

        if (mainFragment == null) {
            mainFragment = AppListFragment.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, mainFragment)
                    .commit();
        }
    }
}
