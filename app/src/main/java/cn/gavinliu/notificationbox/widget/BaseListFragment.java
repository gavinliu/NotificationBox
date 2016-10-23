package cn.gavinliu.notificationbox.widget;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.gavinliu.notificationbox.R;

/**
 * Created by Gavin on 16-10-22.
 */

public abstract class BaseListFragment extends BaseFragment {

    protected View mView;
    protected RecyclerView mRecyclerView;
    protected View mEmptyLayout;
    protected View mProgressLayout;

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.nb_base_list_fragment, null, false);
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (view != null) {
            mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            mEmptyLayout = view.findViewById(R.id.empty_layout);
            mProgressLayout = view.findViewById(R.id.progress_layout);
        }

        setupRecyclerView(mRecyclerView);
    }

    protected void showEmptyView() {
        mEmptyLayout.setVisibility(View.VISIBLE);
    }

    protected void hideEmptyView() {
        mEmptyLayout.setVisibility(View.GONE);
    }

    protected void showProgressView() {
        mProgressLayout.setVisibility(View.VISIBLE);
    }

    protected void hideProgressView() {
        mProgressLayout.setVisibility(View.GONE);
    }

    protected void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
}
