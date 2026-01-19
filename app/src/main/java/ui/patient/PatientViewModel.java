package ui.patient;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import data.PatientRepository;
import data.entities.PatientEntity;
import java.util.List;

public class PatientViewModel extends AndroidViewModel {
    private final PatientRepository repo;
    public PatientViewModel(@NonNull Application app) {
        super(app);
        repo = new PatientRepository(app);
    }

    public LiveData<List<PatientEntity>> getAllPatients() {
        return repo.getAllPatients();
    }

    public LiveData<PatientEntity> getPatient(long id) {
        return repo.getPatient(id);
    }

    public void insertPatient(String name, int age, String gender, String contact) {
        PatientEntity p = new PatientEntity(name, age, gender, contact);
        repo.insert(p);
    }
}
