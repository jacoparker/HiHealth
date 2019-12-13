package com.dragonnetwork.hihealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EditMedicationActivity extends AppCompatActivity {

    TextView prescriptionTextView;
    EditText totalPillsEditText;
    EditText strengthEditText;
    EditText dosageEditText;
    AppCompatCheckBox frequencyMorning;
    AppCompatCheckBox frequencyAfternoon;
    AppCompatCheckBox frequencyEvening;
    RadioGroup Icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_medication);

        prescriptionTextView = findViewById(R.id.medication_name_editText);
        totalPillsEditText = findViewById(R.id.total_pills_editText);
        strengthEditText = findViewById(R.id.medication_strength_editText);
        dosageEditText = findViewById(R.id.medication_dosage_editText);
        frequencyMorning = findViewById(R.id.morning_check);
        frequencyAfternoon = findViewById(R.id.afternoon_check);
        frequencyEvening = findViewById(R.id.evening_check);
        Icon = findViewById(R.id.medication_icon_selection);
        getIncomingIntent();
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
}
