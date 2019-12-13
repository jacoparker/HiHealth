package com.dragonnetwork.hihealth.medication;

import android.content.Context;
import android.content.Intent;
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

import java.util.List;


// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class MedicationAdaptor extends
        RecyclerView.Adapter<MedicationAdaptor.ViewHolder> {

    private List<Medication> medications;

    public Context mContext;

    // Pass in the contact array into the constructor
    public MedicationAdaptor(Context mContext, List<Medication> contacts) {
        this.mContext = mContext;
        medications = contacts;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView medInfo;
        public TextView medInstructions;
        public ImageView icon;
        public LinearLayout parentLayout;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            medInfo = (TextView) itemView.findViewById(R.id.medication_info);
            medInstructions = (TextView) itemView.findViewById(R.id.medication_instructions);
            icon = (ImageView) itemView.findViewById(R.id.medication_icon);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    @NonNull
    public MedicationAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View medView = inflater.inflate(R.layout.card_reminder, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(medView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(final MedicationAdaptor.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Medication med = medications.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.medInfo;
        textView.setText(med.getPrescription() + " - " + med.getStrength() + "/" + med.getTotalNum());
        TextView medInfo = viewHolder.medInstructions;
        int dose = med.getDoses();
        String medStatus;
        if (dose == 1)
            medStatus = "" + dose + " dose";
        else
            medStatus = "" + dose + " doses";
        switch (med.getFrequency()) {
            case (1):
                medStatus += " - morning";
                break;
            case (2):
                medStatus += " - afternoon";
                break;
            case (3):
                medStatus += " - morning and afternoon";
                break;
            case (4):
                medStatus += " - evening";
                break;
            case (5):
                medStatus += " - morning and evening";
                break;
            case (6):
                medStatus += " - afternoon and evening";
                break;
            case (7):
                medStatus += " - morning, afternoon and evening";
                break;
        }
        medInfo.setText(medStatus);

        ImageView icon = viewHolder.icon;
        switch(med.getIconType()) {
            case (R.id.syringe_button):
                icon.setImageResource(R.drawable.syringe);
                break;
            case(R.id.inhaler_button):
                icon.setImageResource(R.drawable.inhaler);
                break;
            default:
                icon.setImageResource(R.drawable.pills);
        }

        final String name = med.getPrescription();
        final int doses = med.getDoses();
        final int numPills = med.getTotalNum();
        final String strength = med.getStrength();
        final int frequency = med.getFrequency();
        final int iconNum = med.getIconType();

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EditMedicationActivity.class);
                intent.putExtra("prescription", name);
                intent.putExtra("doses", doses);
                intent.putExtra("totalPills", numPills);
                intent.putExtra("strength", strength);
                intent.putExtra("frequency", frequency);
                intent.putExtra("icon", iconNum);
                v.getContext().startActivity(intent);
            }
        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return medications.size();
    }
}