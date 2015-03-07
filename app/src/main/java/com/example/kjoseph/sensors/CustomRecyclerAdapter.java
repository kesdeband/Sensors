package com.example.kjoseph.sensors;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kjoseph.sensors.models.Sensor;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Sensor> sensors;

    public CustomRecyclerAdapter(List<Sensor> data) {
        // Pass context or other static stuff that will be needed.
        this.sensors = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {
        if(i%2==0)
            viewHolder.linearLayout.setBackgroundColor(Color.LTGRAY);
        viewHolder.dataSet.setText(String.valueOf(i));
        viewHolder.xAxis.setText(String.valueOf(sensors.get(i).getX_axis()));
        viewHolder.yAxis.setText(String.valueOf(sensors.get(i).getY_axis()));
        viewHolder.zAxis.setText(String.valueOf(sensors.get(i).getZ_axis()));
    }

    @Override
    public int getItemCount() {
        return sensors.size();
    }
}
