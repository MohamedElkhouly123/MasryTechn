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
import com.nglah.masrytechn.network.networkModel.response.driver.GetAllNaqlaResponse;
import com.nglah.masrytechn.network.networkModel.response.driver.UserHistoryResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyHistoryAdapter extends RecyclerView.Adapter<MyHistoryAdapter.ViewHolder> {

    private List<UserHistoryResponse.Datum> listData;
    private Context context;
    private Listener listener;

    public MyHistoryAdapter(List<UserHistoryResponse.Datum> listData, Context context, Listener listener) {
        this.listData = listData;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).
                inflate(R.layout.noti_nglah_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (listData.get(position).getDetails() != null && !listData.get(position).getDetails().equals("")) {
            holder.tv_detail.setText(listData.get(position).getDetails());
        }
        if (listData.get(position).getNaglahType() != null && !listData.get(position).getNaglahType().equals("")) {
            holder.tv_type.setText(listData.get(position).getNaglahType());

        }


        if (listData.get(position).getNaqlaDate() != null && !listData.get(position).getNaqlaDate().equals("")) {
            holder.tv_thingType.setText(listData.get(position).getNaqlaDate());
        }

        if (listData.get(position).getCountry() != null && !listData.get(position).getCountry().equals("")) {
            holder.tv_name.setText(listData.get(position).getCountry());
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
        @BindView(R.id.tv_nglah_name)
        TextView tv_name;
        @BindView(R.id.tv_thing_type)
        TextView tv_thingType;
        @BindView(R.id.tv_nglah_type)
        TextView tv_type;
        @BindView(R.id.tv_details)
        TextView tv_detail;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }

}
