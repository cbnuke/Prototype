package com.cbnuke.prototype;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cbnuke.prototype.model.StatusQueue;

import java.util.List;

/**
 * Created by Amnart on 13/1/2560.
 */

public class QueueAdapter extends RecyclerView.Adapter<QueueAdapter.ViewHolder> {
    private List<StatusQueue.DataEntity> mPlayers;
    private Context mContext;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_queue, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtDep;
        public TextView txtWait;
        public TextView txtStatus;

        public ViewHolder(View view) {
            super(view);

            txtDep = (TextView) view.findViewById(R.id.txtDep);
            txtStatus = (TextView) view.findViewById(R.id.txtStatus);
            txtWait = (TextView) view.findViewById(R.id.txtWait);
        }
    }

}
