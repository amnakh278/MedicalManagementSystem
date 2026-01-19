package com.example.medicalmanagementsystem.ui.patient;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.medicalmanagementsystem.R;

import ui.patient.PatientTreatmentsActivity;

import ui.patient.PatientViewModel;
public class PatientHomeActivity extends ComponentActivity {
    public static final String EXTRA_PATIENT_ID = "patient_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);

        long patientId = getIntent().getLongExtra(EXTRA_PATIENT_ID, -1);

        // 1) Bind your views, including the buttons:
        TextView tvName    = findViewById(R.id.tvName);
        TextView tvDetails = findViewById(R.id.tvDetails);
        Button btnViewBills       = findViewById(R.id.btnViewBills);
        Button btnViewTreatments  = findViewById(R.id.btnViewTreatments);
        Button btnBookAppointment = findViewById(R.id.btnBookAppointment);

        // 2) Observe the patient record and populate your TextViews:
        PatientViewModel vm = new ViewModelProvider(this)
                .get(PatientViewModel.class);
        vm.getPatient(patientId).observe(this, patient -> {
            if (patient != null) {
                tvName.setText(patient.getName());
                tvDetails.setText(
                        "Age: " + patient.getAge() +
                                " | Gender: " + patient.getGender() +
                                "\nContact: " + patient.getContact()
                );
            }
        });

        // 3) Hook up each button’s click to launch the proper screen:
        btnViewBills.setOnClickListener(v -> {
            Intent i = new Intent(this, PatientBillsActivity.class);
            i.putExtra(PatientBillsActivity.EXTRA_PATIENT_ID, patientId);
            startActivity(i);
        });

        btnViewTreatments.setOnClickListener(v -> {
            Intent i = new Intent(this, PatientTreatmentsActivity.class);
            i.putExtra(PatientTreatmentsActivity.EXTRA_PATIENT_ID, patientId);
            startActivity(i);
        });

        btnBookAppointment.setOnClickListener(v -> {
            Intent i = new Intent(this, AppointmentCreateActivity.class);
            i.putExtra(AppointmentCreateActivity.EXTRA_PATIENT_ID, patientId);
            startActivity(i);
        });
    }
}
