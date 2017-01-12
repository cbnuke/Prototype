package com.cbnuke.prototype;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cbnuke.prototype.model.StatusAppoint;
import com.cbnuke.prototype.model.StatusQueue;

import java.util.List;

/**
 * Created by Amnart on 13/1/2560.
 */

public class AppointAdapter extends RecyclerView.Adapter<AppointAdapter.ViewHolder> {
    private List<StatusAppoint.DataEntity> mQueues;
    private Context mContext;

    public AppointAdapter(Context mContext, List<StatusAppoint.DataEntity> dataset) {
        mQueues = dataset;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_appoint, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StatusAppoint.DataEntity queue = mQueues.get(position);
        holder.txtDep.setText(queue.getDep_name_th());
        holder.txtDetail.setText(queue.getDetail());
        holder.txtDate.setText(queue.getApp_date());
    }

    @Override
    public int getItemCount() {
        return mQueues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtDep;
        public TextView txtDate;
        public TextView txtDetail;

        public ViewHolder(View view) {
            super(view);
            txtDep = (TextView) view.findViewById(R.id.txtDep);
            txtDate = (TextView) view.findViewById(R.id.txtDate);
            txtDetail = (TextView) view.findViewById(R.id.txtDetail);
        }
    }

}
