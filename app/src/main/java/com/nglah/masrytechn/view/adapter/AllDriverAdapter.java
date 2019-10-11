package com.nglah.masrytechn.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nglah.masrytechn.Listener;
import com.nglah.masrytechn.R;
import com.nglah.masrytechn.model.Driver;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AllDriverAdapter extends RecyclerView.Adapter<AllDriverAdapter.ViewHolder> {
    private List<Driver> listData;
    private Context context;
    private Listener listener;

    public AllDriverAdapter(List<Driver> listData, Context context, Listener listener) {
        this.listData = listData;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.noti_nglah_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nglah_name)
        TextView name;
        @BindView(R.id.tv_thing_type)
        TextView thingType;
        @BindView(R.id.tv_nglah_type)
        TextView naglahTtype;
        @BindView(R.id.tv_details)
        TextView detail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}