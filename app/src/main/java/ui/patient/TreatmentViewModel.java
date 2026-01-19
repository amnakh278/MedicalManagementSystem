package ui.patient;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import data.TreatmentRepository;
import data.entities.TreatmentEntity;
import java.util.List;

public class TreatmentViewModel extends AndroidViewModel {
    private final TreatmentRepository repo;
    public TreatmentViewModel(@NonNull Application app) {
        super(app);
        repo = new TreatmentRepository(app);
    }
    public LiveData<List<TreatmentEntity>> getTreatments(long pid) {
        return repo.getTreatmentsForPatient(pid);
    }
}
