package cn.gavinliu.notificationbox.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.gavinliu.notificationbox.R;

/**
 * Created by Gavin on 2016/10/11.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applist);

        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_applist);

        if (detailFragment == null) {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            detailFragment = DetailFragment.newInstance(bundle.getString("appName"), bundle.getString("packageName"));

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, detailFragment)
                    .commit();
        }

        new DetailPresenter(detailFragment);
    }
}
