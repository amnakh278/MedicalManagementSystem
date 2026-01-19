package com.example.medicalmanagement.patient;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.medicalmanagement.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PatientHomeActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);

        BottomNavigationView nav = findViewById(R.id.patient_bottom_nav);
        nav.setOnItemSelectedListener(item -> {
            Fragment f;
            switch (item.getItemId()) {
                case R.id.menu_bills:
                    f = new BillsHistoryFragment();
                    break;
                case R.id.menu_treatment:
                    f = new TreatmentHistoryFragment();
                    break;
                case R.id.menu_appoint:
                    f = new AppointmentFragment();
                    break;
                default:
                    f = new PatientProfileFragment();
            }
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.patient_fragment_container, f)
                .commit();
            return true;
        });

        if (savedInstanceState == null)
            nav.setSelectedItemId(R.id.menu_profile);
    }
}