package com.thedeveloperworldisyours.fullrecycleview.horizontal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thedeveloperworldisyours.fullrecycleview.R;

import java.util.ArrayList;

/**
 * Created by javierg on 12/10/2016.
 */

public class HorizontalRecyclerViewAdapter extends RecyclerView
        .Adapter<HorizontalRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<HorizontalData> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView mLabel;
        TextView mDateTime;

        public DataObjectHolder(View itemView) {
            super(itemView);
            mLabel = (TextView) itemView.findViewById(R.id.horizontal_list_item_text_view);
            mDateTime = (TextView) itemView.findViewById(R.id.horizontal_list_item_text_view_two);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public HorizontalRecyclerViewAdapter(ArrayList<HorizontalData> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_list_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.mLabel.setText(mDataset.get(position).getmTitle());
        holder.mDateTime.setText(mDataset.get(position).getmSubTitle());
    }

    public void addItem(HorizontalData dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
