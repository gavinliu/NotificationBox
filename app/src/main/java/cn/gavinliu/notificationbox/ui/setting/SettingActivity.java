package cn.gavinliu.notificationbox.ui.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import cn.gavinliu.notificationbox.R;
import cn.gavinliu.notificationbox.widget.BaseActivity;

/**
 * Created by Gavin on 2016/10/12.
 */

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
