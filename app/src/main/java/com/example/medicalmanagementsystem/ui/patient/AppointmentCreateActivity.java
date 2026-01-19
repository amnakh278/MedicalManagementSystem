package com.example.medicalmanagementsystem.ui.patient;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import com.example.medicalmanagementsystem.R;

public class AppointmentCreateActivity extends ComponentActivity {
    public static final String EXTRA_PATIENT_ID = "patient_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_create);
        // TODO: implement your appointment‐booking form here
    }
}

