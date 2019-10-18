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
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AllDriverResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AllDriverAdapter extends RecyclerView.Adapter<AllDriverAdapter.ViewHolder> {
    private List<AllDriverResponse.Datum> listData;
    private Context context;
    private Listener listener;

    public AllDriverAdapter(List<AllDriverResponse.Datum> listData, Context context, Listener listener) {
        this.listData = listData;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).
                inflate(R.layout.noti_driver_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        if (listData.get(position).getFname()!=null&&!listData.get(position).equals("")){
            holder.name.setText(listData.get(position).getFname()+" "+listData.get(position).getLname());
        }


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
        @BindView(R.id.tv_phone)
        TextView name;
        @BindView(R.id.tv_rate)
        TextView tv_rate;
        @BindView(R.id.tv_price)
        TextView tv_price;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}