package com.dragonnetwork.hihealth.reminder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dragonnetwork.hihealth.EditMedicationActivity;
import com.dragonnetwork.hihealth.R;
import com.dragonnetwork.hihealth.data.Medication;
import com.dragonnetwork.hihealth.data.Reminder;

import java.util.List;


// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ReminderAdaptor extends
        RecyclerView.Adapter<ReminderAdaptor.ViewHolder> {

    private List<Reminder> reminders;
    private OnItemClickListener mListener;

    public Context mContext;

    int position = 0;

    // Pass in the contact array into the constructor
    public ReminderAdaptor(Context mContext, List<Reminder> contacts) {
        this.mContext = mContext;
        reminders = contacts;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView remInfo;
        public TextView remInstructions;
        public ImageView icon;
        public LinearLayout parentLayout;
        public LinearLayout highlightLayout;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView, final OnItemClickListener listener) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            remInfo = (TextView) itemView.findViewById(R.id.medication_info);
            remInstructions = (TextView) itemView.findViewById(R.id.medication_instructions);
            icon = (ImageView) itemView.findViewById(R.id.medication_icon);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            highlightLayout = itemView.findViewById(R.id.highlight_layout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            listener.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View medView = inflater.inflate(R.layout.card_reminder, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(medView, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
        Reminder rem = reminders.get(position);

        // Set item views based on your views and data model
        TextView textView;
        textView = holder.remInfo;
        textView.setText(rem.getInfo());
        TextView remInfo = holder.remInstructions;
        remInfo.setText(rem.getInstructions());

        ImageView icon = holder.icon;
        switch(rem.getType()) {
            case (R.id.syringe_button):
                icon.setImageResource(R.drawable.syringe);
                break;
            case(R.id.inhaler_button):
                icon.setImageResource(R.drawable.inhaler);
                break;
            default:
                icon.setImageResource(R.drawable.pills);
        }
    }

    // Involves populating data into the item through holder

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return reminders.size();
    }

//    public void morningRVOnClick(View view) {
//
//        viewHolderListener.onIndexChanged(position);
//        selectedPosition = getPosition();
//        view.setBackgroundColor(Color.CYAN);
//        selectedListItem = view;
//    }
}