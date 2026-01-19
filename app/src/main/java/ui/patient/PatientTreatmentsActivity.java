package ui.patient;

import android.os.Bundle;

import androidx.activity.ComponentActivity;     // ← make sure this import is here
// or:  import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicalmanagementsystem.R;

public class PatientTreatmentsActivity extends ComponentActivity {  // ← or AppCompatActivity

    public static final String EXTRA_PATIENT_ID = "patient_id";
    private TreatmentViewModel vm;

    @Override
    protected void onCreate(@Nullable Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_patient_treatments);

        long pid = getIntent().getLongExtra(EXTRA_PATIENT_ID, -1);
        RecyclerView rv = findViewById(R.id.rvTreatments);
        rv.setLayoutManager(new LinearLayoutManager(this));

        vm = new ViewModelProvider(this).get(TreatmentViewModel.class);
        vm.getTreatments(pid).observe(this, list ->
                rv.setAdapter(new TreatmentAdapter(list))
        );
    }
}

