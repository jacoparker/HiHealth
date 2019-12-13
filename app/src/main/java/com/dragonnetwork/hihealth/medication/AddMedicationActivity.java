package com.dragonnetwork.hihealth.medication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.dragonnetwork.hihealth.R;
import com.dragonnetwork.hihealth.data.User;
import com.dragonnetwork.hihealth.cloudio.CloudIO;
import com.dragonnetwork.hihealth.data.Medication;
import com.dragonnetwork.hihealth.data.User;


public class AddMedicationActivity extends AppCompatActivity {
    EditText MedicationName;
    EditText TotalPills;
    EditText Strength;
    EditText Dosage;
    AppCompatCheckBox frequencyMorning;
    AppCompatCheckBox frequencyAfternoon;
    AppCompatCheckBox frequencyEvening;
    RadioGroup Icon;
    Button Addbt;
    final String TAG = "AddMedicationActivity";
    ProgressDialog progressDialog;

    int iconChoice;

    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        MedicationName = findViewById(R.id.medication_name_editText);
        TotalPills = findViewById(R.id.total_pills_editText);
        Strength = findViewById(R.id.medication_strength_editText);
        Dosage = findViewById(R.id.medication_dosage_editText);
        frequencyMorning = findViewById(R.id.morning_check);
        frequencyAfternoon = findViewById(R.id.afternoon_check);
        frequencyEvening = findViewById(R.id.evening_check);
        Icon = findViewById(R.id.medication_icon_selection);
        Icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();

                // Check which radio button was clicked
                switch(v.getId()) {
                    case R.id.inhaler_button:
                        if (checked)
                            iconChoice = 1;
                        break;
                    case R.id.syringe_button:
                        if (checked)
                            iconChoice = 2;
                        break;
                    case R.id.pills_button:
                        if (checked)
                            iconChoice = 3;
                        break;
                }
            }
        });
        Addbt = findViewById(R.id.Addbt);
        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initProgressDialog();

        //disable button and show progress dialog
        Addbt.setEnabled(true);

        onBtnClick();
    }
        public void onBtnClick() {

            Addbt.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                progressDialog.show();
                Addbt.setEnabled(false);
                    if (validateForm()) {
                        int frequency = 0;
                        if (frequencyMorning.isChecked())
                            frequency += 1;
                        if (frequencyAfternoon.isChecked())
                            frequency += 2;
                        if (frequencyEvening.isChecked())
                            frequency += 4;
                        User.addMedication(MedicationName.getText().toString(),
                                Integer.parseInt(TotalPills.getText().toString()),
                                Strength.getText().toString(),
                                Integer.parseInt(Dosage.getText().toString()),
                                frequency,
                                Icon.getCheckedRadioButtonId());
                        progressDialog.dismiss();
                        Addbt.setEnabled(true);
                        Intent intent = new Intent(getApplicationContext(),MedicationActivity.class);
                        startActivity(intent);
                    }
                    else {
                        progressDialog.dismiss();
                        Addbt.setEnabled(true);
                    }
                }
            });
        }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.syringe_button:
                if (checked)
                    this.iconChoice = 1;
                break;
            case R.id.inhaler_button:
                if (checked)
                    this.iconChoice = 2;
                    break;
            case R.id.pills_button:
                if (checked)
                    this.iconChoice = 3;
                    break;
        }
    }

    public void initProgressDialog(){
        progressDialog = new ProgressDialog(AddMedicationActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Adding Medication...");
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private boolean validateForm() {
        //TODO: Implement this method according to our design.
        boolean valid = true;
        //Check Name, type, frequency, dosage, strength, total number

        if(TextUtils.isEmpty(MedicationName.getText().toString()))
        {
            MedicationName.setError("Required");
            valid = false;
        }
        else{
            MedicationName.setError(null);
        }

        if(TextUtils.isEmpty(TotalPills.getText().toString()))
        {
            TotalPills.setError("Required");
            valid = false;
        }
        else{
            TotalPills.setError(null);
        }

        if(TextUtils.isEmpty(Strength.getText().toString()))
        {
            Strength.setError("Required");
            valid = false;
        }
        else{
            Strength.setError(null);
        }

        if(TextUtils.isEmpty(Dosage.getText().toString()))
        {
            Dosage.setError("Required");
            valid = false;
        }
        else{
            Dosage.setError(null);
        }

        if(!frequencyMorning.isChecked() && !frequencyAfternoon.isChecked() && !frequencyEvening.isChecked())
        {
            frequencyMorning.setError("Required");
            frequencyAfternoon.setError("Required");
            frequencyEvening.setError("Required");
            valid = false;
        }
        else{
            frequencyEvening.setError(null);
            frequencyMorning.setError(null);
            frequencyAfternoon.setError(null);
        }
        return valid;
    }
}