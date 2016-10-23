package cn.gavinliu.notificationbox.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.gavinliu.notificationbox.R;
import cn.gavinliu.notificationbox.model.AppInfo;
import cn.gavinliu.notificationbox.ui.applist.AppListActivity;
import cn.gavinliu.notificationbox.ui.detail.DetailActivity;
import cn.gavinliu.notificationbox.widget.BaseListFragment;
import cn.gavinliu.notificationbox.widget.BaseViewHolder;

/**
 * Created by Gavin on 2016/10/11.
 */

public class MainFragment extends BaseListFragment implements MainContract.View {

    MainContract.Presenter mPresenter;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mPresenter != null) mPresenter.startLoad(getActivity().getPackageManager());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.unsubscribe();
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
    public void showProgress(boolean isShown) {
        if (isShown) {
            showProgressView();
        } else {
            hideProgressView();
        }
    }

    @Override
    public void showApp(List<AppInfo> apps) {
        mRecyclerView.setAdapter(new Adapter(getContext(), apps, mItemListener));
    }

    @Override
    public void showAppList() {
        Intent intent = new Intent(getContext(), AppListActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    public void showDetail(String appName, String packageName) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("appName", appName);
        intent.putExtra("packageName", packageName);
        startActivity(intent);
    }

    private ItemListener mItemListener = new ItemListener() {
        @Override
        public void onItemClick(AppInfo app) {
            mPresenter.openDetail(app);
        }
    };

    private static class Adapter extends RecyclerView.Adapter<ViewHolder> {

        Context context;
        List<AppInfo> appList;
        ItemListener itemListener;

        public Adapter(Context context, List<AppInfo> appList, ItemListener itemListener) {
            this.context = context;
            this.appList = appList;
            this.itemListener = itemListener;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final AppInfo app = appList.get(position);

            holder.mIconView.setImageDrawable(app.getIcon());
            holder.mNameView.setText(app.getAppName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.onItemClick(app);
                }
            });
        }

        @Override
        public int getItemCount() {
            return appList != null ? appList.size() : 0;
        }
    }

    private static class ViewHolder extends BaseViewHolder {

        private ImageView mIconView;
        private TextView mNameView;


        public ViewHolder(View itemView) {
            super(itemView);

            mIconView = (ImageView) itemView.findViewById(R.id.icon);
            mNameView = (TextView) itemView.findViewById(R.id.name);
        }
    }

    private interface ItemListener {
        void onItemClick(AppInfo app);
    }
}
