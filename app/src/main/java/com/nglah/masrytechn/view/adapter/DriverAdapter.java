package com.nglah.masrytechn.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nglah.masrytechn.DriverListener;
import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.response.driver.UserHistoryResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.ViewHolder> {
    private List<UserHistoryResponse.Driver> listData;
    private Context context;
    private DriverListener listener;

    public DriverAdapter(List<UserHistoryResponse.Driver> listData, Context context, DriverListener listener) {
        this.listData = listData;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).
                inflate(R.layout.single_driver_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.name.setText(listData.get(position).getFname() + " " + listData.get(position).getLname());
        holder.price.setText(listData.get(position).getPrice() + " ");


        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.accept();
            }
        });
        holder.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.chat();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.accept)
        Button accept;
        @BindView(R.id.chat)
        Button chat;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}
