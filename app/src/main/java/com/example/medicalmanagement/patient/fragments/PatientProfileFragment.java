package com.example.medicalmanagement.patient.fragments;

import android.os.Bundle;
import android.view.*;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.medicalmanagement.R;

public class PatientProfileFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient_profile, container, false);
    }
}