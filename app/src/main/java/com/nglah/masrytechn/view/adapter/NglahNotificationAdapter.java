package com.nglah.masrytechn.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.nglah.masrytechn.R;
import com.nglah.masrytechn.model.Driver;

import java.util.List;

public class NglahNotificationAdapter extends RecyclerView.Adapter<NglahNotificationAdapter.NumberViewHolder>{

    private static final String TAG = NglahNotificationAdapter.class.getSimpleName();

    final private ListItemClickListener mOnClickListener;

    private List<Driver> drivers;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public NglahNotificationAdapter(List<Driver> drivers, ListItemClickListener listener) {
        this.drivers = drivers;
        this.mOnClickListener = listener;
    }



    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.noti_driver_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }


    @Override
    public int getItemCount() {
        return drivers.size();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView listItemDriverName;
        TextView listItemDriverPhone;
        TextView listItemDriverPrice;
        TextView listItemDriverRate;

        public NumberViewHolder(View itemView) {
            super(itemView);
            listItemDriverName = itemView.findViewById(R.id.tv_driver_name);
            listItemDriverPhone = itemView.findViewById(R.id.tv_phone);
            listItemDriverPrice = itemView.findViewById(R.id.tv_price);
            listItemDriverRate = itemView.findViewById(R.id.tv_rate);

            itemView.setOnClickListener(this);
        }


        void bind(int listIndex) {
            listItemDriverName.setText(
                    drivers.get(listIndex).getFirstName() +
                            " " + drivers.get(listIndex).getLastName());
            listItemDriverPhone.setText("T: " + drivers.get(listIndex).getPhone());
            listItemDriverPrice.setText(". " + drivers.get(listIndex).getPrice() + " SR");
            listItemDriverRate.setText(drivers.get(listIndex).getRate());
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
