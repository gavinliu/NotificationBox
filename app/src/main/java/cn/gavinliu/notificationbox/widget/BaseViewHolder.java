package cn.gavinliu.notificationbox.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Gavin on 2016/10/12.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
