package com.nglah.masrytechn.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nglah.masrytechn.DriverListener;
import com.nglah.masrytechn.R;
import com.nglah.masrytechn.model.ChatModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;

public class ChatAdpater extends RecyclerView.Adapter<ChatAdpater.ViewHolder> {
    private List<ChatModel> listData;
    private Context context;
    private DriverListener listener;

    public ChatAdpater(List<ChatModel> listData, Context context) {
        this.listData = listData;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).
                inflate(R.layout.chat_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (listData.get(position).getOwnerId().equals(loggedInUser.getId())) {
            holder.sender.setVisibility(View.VISIBLE);
            holder.sender.setText(listData.get(position).getMessage());
        } else {
            holder.receiver.setVisibility(View.VISIBLE);
            holder.receiver.setText(listData.get(position).getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_receiver)
        TextView receiver;
        @BindView(R.id.tv_sender)
        TextView sender;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}