package ui.patient;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.medicalmanagementsystem.R;

public class PatientCreateActivity extends ComponentActivity {
    private PatientViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_create);

        vm = new ViewModelProvider(this).get(PatientViewModel.class);

        EditText etName    = findViewById(R.id.etName);
        EditText etAge     = findViewById(R.id.etAge);
        Spinner spinner    = findViewById(R.id.spinnerGender);
        EditText etContact = findViewById(R.id.etContact);
        Button btnCreate   = findViewById(R.id.btnCreate);

        // Spinner adapter already from XML entries
        btnCreate.setOnClickListener(v -> {
            String name    = etName.getText().toString().trim();
            String ageStr  = etAge.getText().toString().trim();
            String gender  = spinner.getSelectedItem().toString();
            String contact = etContact.getText().toString().trim();

            if (name.isEmpty() || ageStr.isEmpty() || contact.isEmpty()) {
                Toast.makeText(this, "All fields required!", Toast.LENGTH_SHORT).show();
                return;
            }
            int age = Integer.parseInt(ageStr);
            vm.insertPatient(name, age, gender, contact);
            Toast.makeText(this, "Patient created 🚀", Toast.LENGTH_SHORT).show();
            finish(); // go back
        });
    }
}
