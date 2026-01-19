package  com.example.medicalmanagementsystem.ui.patient;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.medicalmanagementsystem.R;

import ui.patient.BillViewModel;

public class PatientBillsActivity extends ComponentActivity {
    public static final String EXTRA_PATIENT_ID = "patient_id";

    private BillViewModel billViewModel;
    private RecyclerView rvBills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_bills);

        long patientId = getIntent().getLongExtra(EXTRA_PATIENT_ID, -1);

        rvBills = findViewById(R.id.rvBills);
        rvBills.setLayoutManager(new LinearLayoutManager(this));

        billViewModel = new ViewModelProvider(this).get(BillViewModel.class);

        billViewModel
                .getBillsForPatient(patientId)
                .observe(this, bills -> {
                    // Create a new adapter each time for simplicity
                    BillAdapter adapter = new BillAdapter(bills);
                    rvBills.setAdapter(adapter);
                });
    }
}

