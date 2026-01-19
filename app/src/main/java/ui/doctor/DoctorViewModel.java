package ui.doctor;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import data.DoctorRepository;
import data.entities.DoctorEntity;
import java.util.List;

public class DoctorViewModel extends AndroidViewModel {
    private final DoctorRepository repo;
    public DoctorViewModel(@NonNull Application app) {
        super(app);
        repo = new DoctorRepository(app);
    }
    public LiveData<DoctorEntity> getDoctor(long id) { return repo.getDoctor(id); }
    public LiveData<List<DoctorEntity>> getAllDoctors() { return repo.getAllDoctors(); }
    public void insertDoctor(String name, String spec, String contact) {
        repo.insert(new DoctorEntity(name, spec, contact));
    }
}
