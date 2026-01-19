package ui.doctor;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.medicalmanagementsystem.R;
import com.example.medicalmanagementsystem.R;

public class DoctorProfileActivity extends ComponentActivity {
    public static final String EXTRA_DOCTOR_ID = "doctor_id";

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_doctor_profile);

        long did = getIntent().getLongExtra(EXTRA_DOCTOR_ID, -1);
        TextView tvName   = findViewById(R.id.tvDocName);
        TextView tvDetail = findViewById(R.id.tvDocDetail);

        DoctorViewModel vm = new ViewModelProvider(this).get(DoctorViewModel.class);
        vm.getDoctor(did).observe(this, d -> {
            if (d != null) {
                tvName.setText(d.getName());
                tvDetail.setText("Specialty: " + d.getSpecialization() +
                        "\nContact: " + d.getContact());
            }
        });
    }
}
