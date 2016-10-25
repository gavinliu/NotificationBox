package cn.gavinliu.notificationbox.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import cn.gavinliu.notificationbox.R;
import cn.gavinliu.notificationbox.service.NotificationListenerService;
import cn.gavinliu.notificationbox.ui.setting.SettingActivity;
import cn.gavinliu.notificationbox.utils.CommonUtils;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton mFloatingActionButton;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPresenter.addApp();
            }
        });

        MainFragment mainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_main);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, mainFragment)
                    .commit();
        }

        mMainPresenter = new MainPresenter(mainFragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!CommonUtils.checkNotificationReadPermission(this)) {
            Snackbar.make(mFloatingActionButton, "检测到没有权限", Snackbar.LENGTH_INDEFINITE)
                    .setAction("设置", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                            startActivity(intent);
                        }
                    })
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
