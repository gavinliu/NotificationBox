package cn.gavinliu.notificationbox.ui.applist;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.gavinliu.notificationbox.R;
import cn.gavinliu.notificationbox.model.AppInfo;
import cn.gavinliu.notificationbox.ui.main.MainContract;
import cn.gavinliu.notificationbox.widget.BaseViewHolder;

/**
 * Created by Gavin on 16-10-17.
 */

public class AppListFragment extends Fragment implements AppListContract.View {

    private RecyclerView mRecyclerView;

    AppListContract.Presenter mPresenter;

    public static AppListFragment newInstance() {
        AppListFragment fragment = new AppListFragment();
        return fragment;
    }

    private View mView;

    @Override
    public void setPresenter(AppListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_applist, null, false);
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        }
    }

    private List<AppInfo> mApps;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mPresenter != null) mPresenter.startLoad(getActivity().getPackageManager());
    }

    @Override
    public void showAppList(List<AppInfo> appList) {
        mRecyclerView.setAdapter(new Adapter(getContext(), appList, mItemListener));
    }

    private ItemListener mItemListener = new ItemListener() {
        @Override
        public void onCheckBoxSelect(boolean isChecked, AppInfo app) {
            if (isChecked) {
                mPresenter.saveApp(app);
            } else {
                mPresenter.deleteApp(app);
            }
        }
    };

    private static class Adapter extends RecyclerView.Adapter<ViewHolder> {

        Context context;
        List<AppInfo> appList;
        private ItemListener itemListener;

        public Adapter(Context context, List<AppInfo> appList, ItemListener itemListener) {
            this.context = context;
            this.appList = appList;
            this.itemListener = itemListener;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_applist, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final AppInfo app = appList.get(position);

            holder.mIconView.setImageDrawable(app.getIcon());
            holder.mNameView.setText(app.getAppName());
            holder.mCheckBox.setChecked(app.isSelect());

            holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.onCheckBoxSelect(((CheckBox) v).isChecked(), app);
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
        private CheckBox mCheckBox;


        public ViewHolder(View itemView) {
            super(itemView);

            mIconView = (ImageView) itemView.findViewById(R.id.icon);
            mNameView = (TextView) itemView.findViewById(R.id.name);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }

    public interface ItemListener {
        void onCheckBoxSelect(boolean isChecked, AppInfo app);
    }

}
