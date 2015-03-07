package com.example.kjoseph.sensors;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout linearLayout;
    public TextView dataSet;
    public TextView xAxis;
    public TextView yAxis;
    public TextView zAxis;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.parentList);
        dataSet = (TextView) itemView.findViewById(R.id.dataSet);
        xAxis = (TextView) itemView.findViewById(R.id.txt_x_axis);
        yAxis = (TextView) itemView.findViewById(R.id.txt_y_axis);
        zAxis = (TextView) itemView.findViewById(R.id.txt_z_axis);
    }
}
