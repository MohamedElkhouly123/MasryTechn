package com.nglah.masrytechn.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.nglah.masrytechn.R;
import com.nglah.masrytechn.model.NAGLA;

import java.util.List;

public class DriverNotificationAdapter extends RecyclerView.Adapter<DriverNotificationAdapter.NumberViewHolder>{

     private static final String TAG = NglahNotificationAdapter.class.getSimpleName();


    final private ListItemClickListener mOnClickListener;

    private List<NAGLA> nglahOrders;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public DriverNotificationAdapter(List<NAGLA> nglahOrders, ListItemClickListener listener) {

        this.nglahOrders = nglahOrders;
        this.mOnClickListener = listener;
    }


    @Override
    public DriverNotificationAdapter.NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.noti_nglah_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        DriverNotificationAdapter.NumberViewHolder viewHolder = new DriverNotificationAdapter.NumberViewHolder(view);

        return viewHolder;
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the correct
     * indices in the list for this particular position, using the "position" argument that is conveniently
     * passed into us.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(DriverNotificationAdapter.NumberViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available in our forecast
     */
    @Override
    public int getItemCount() {
        return nglahOrders.size();
    }

    /**
     * Cache of the children views for a list item.
     */
    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView listItemNglahName;
        TextView listItemThingType;
        TextView listItemNglahType;
        TextView listItemNglahDetails;

        public NumberViewHolder(View itemView) {
            super(itemView);
            listItemNglahName = itemView.findViewById(R.id.tv_nglah_name);
            listItemThingType = itemView.findViewById(R.id.tv_thing_type);
            listItemNglahType = itemView.findViewById(R.id.tv_nglah_type);
            listItemNglahDetails = itemView.findViewById(R.id.tv_details);

            itemView.setOnClickListener(this);
        }


        void bind(int listIndex) {

            listItemNglahName.setText(
                    nglahOrders.get(listIndex).getFirstName() +
                            " " + nglahOrders.get(listIndex).getLastName());
            listItemThingType.setText(nglahOrders.get(listIndex).getThingType());
            listItemNglahType.setText(nglahOrders.get(listIndex).getNglahType());
            listItemNglahDetails.setText(nglahOrders.get(listIndex).getDetails());
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
