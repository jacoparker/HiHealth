package com.dragonnetwork.hihealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dragonnetwork.hihealth.cloudio.CloudIO;
import com.dragonnetwork.hihealth.data.User;
import com.dragonnetwork.hihealth.medication.MedicationActivity;

public class EditMedicationActivity extends AppCompatActivity {

    TextView prescriptionTextView;
    EditText totalPillsEditText;
    EditText strengthEditText;
    EditText dosageEditText;
    AppCompatCheckBox frequencyMorning;
    AppCompatCheckBox frequencyAfternoon;
    AppCompatCheckBox frequencyEvening;
    RadioGroup Icon;
    String medID;

    Button saveButton;
    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_medication);

        saveButton = findViewById(R.id.button_save_changes);
        deleteButton = findViewById(R.id.button_delete_medication);
        prescriptionTextView = findViewById(R.id.medication_name_editText);
        totalPillsEditText = findViewById(R.id.total_pills_editText);
        strengthEditText = findViewById(R.id.medication_strength_editText);
        dosageEditText = findViewById(R.id.medication_dosage_editText);
        frequencyMorning = findViewById(R.id.morning_check);
        frequencyAfternoon = findViewById(R.id.afternoon_check);
        frequencyEvening = findViewById(R.id.evening_check);
        Icon = findViewById(R.id.medication_icon_selection);
        getIncomingIntent();

        onBtnClick();
    }

    public void onBtnClick() {
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteButton.setEnabled(false);
                User.removeMedication(medID, EditMedicationActivity.this);
                deleteButton.setEnabled(true);
                Intent intent = new Intent(getApplicationContext(), MedicationActivity.class);
                startActivity(intent);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveButton.setEnabled(false);
                if (validateForm()) {
                    int frequency = 0;
                    if (frequencyMorning.isChecked())
                        frequency += 1;
                    if (frequencyAfternoon.isChecked())
                        frequency += 2;
                    if (frequencyEvening.isChecked())
                        frequency += 4;
                    User.addMedication(prescriptionTextView.getText().toString(),
                            Integer.parseInt(totalPillsEditText.getText().toString()),
                            strengthEditText.getText().toString(),
                            Integer.parseInt(dosageEditText.getText().toString()),
                            frequency,
                            Icon.getCheckedRadioButtonId());
                    saveButton.setEnabled(true);
                    Intent intent = new Intent(getApplicationContext(), MedicationActivity.class);
                    startActivity(intent);
                    finish();
                    User.removeMedication(medID, EditMedicationActivity.this);
                    Intent i = new Intent(getApplicationContext(), MedicationActivity.class);
                    startActivity(i);
                }
                else {
                    saveButton.setEnabled(true);
                }
            }
        });
    }

    private void getIncomingIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("prescription") && intent.hasExtra("doses")
            && intent.hasExtra("totalPills") && intent.hasExtra("strength")
            && intent.hasExtra("frequency") && intent.hasExtra("icon"))
        {
            prescriptionTextView.setText(intent.getStringExtra("prescription"));
            totalPillsEditText.setText("" + intent.getIntExtra("totalPills",0));
            strengthEditText.setText(intent.getStringExtra("strength"));
            dosageEditText.setText("" + intent.getIntExtra("doses",0));
            this.medID = intent.getStringExtra("medID");
            switch (intent.getIntExtra("frequency",0)) {
                case (1):
                    frequencyMorning.setChecked(true);
                    break;
                case(2):
                    frequencyAfternoon.setChecked(true);
                    break;
                case(3):
                    frequencyAfternoon.setChecked(true);
                    frequencyMorning.setChecked(true);
                    break;
                case(4):
                    frequencyEvening.setChecked(true);
                    break;
                case(5):
                    frequencyMorning.setChecked(true);
                    frequencyEvening.setChecked(true);
                    break;
                case(6):
                    frequencyAfternoon.setChecked(true);
                    frequencyEvening.setChecked(true);
                    break;
                case(7):
                    frequencyMorning.setChecked(true);
                    frequencyAfternoon.setChecked(true);
                    frequencyEvening.setChecked(true);
            }

            int choice = intent.getIntExtra("icon",0);
            RadioButton rb;
            switch(choice) {
                case (1):
                    rb = Icon.findViewById(R.id.syringe_button);
                    rb.setChecked(true);
                    break;
                case (2):
                    rb = Icon.findViewById(R.id.inhaler_button);
                    rb.setChecked(true);
                default:
                    rb = Icon.findViewById(R.id.pills_button);
                    rb.setChecked(true);
            }
        }
    }

    private boolean validateForm() {
        //TODO: Implement this method according to our design.
        boolean valid = true;
        //Check Name, type, frequency, dosage, strength, total number

        if(TextUtils.isEmpty(totalPillsEditText.getText().toString()))
        {
            totalPillsEditText.setError("Required");
            valid = false;
        }
        else{
            totalPillsEditText.setError(null);
        }

        if(TextUtils.isEmpty(strengthEditText.getText().toString()))
        {
            strengthEditText.setError("Required");
            valid = false;
        }
        else{
            strengthEditText.setError(null);
        }

        if(TextUtils.isEmpty(dosageEditText.getText().toString()))
        {
            dosageEditText.setError("Required");
            valid = false;
        }
        else{
            dosageEditText.setError(null);
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

        // w   Log.w(TAG,"valid = " + valid);
        return valid;
    }
}
