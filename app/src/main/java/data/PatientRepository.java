package data;

import android.content.Context;
import androidx.lifecycle.LiveData;
import data.dao.PatientDao;
import data.entities.PatientEntity;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PatientRepository {
    private final PatientDao dao;
    private final ExecutorService io;

    public PatientRepository(Context ctx) {
        AppDatabase db = AppDatabase.getInstance(ctx);
        dao = db.patientDao();
        io  = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<PatientEntity>> getAllPatients() {
        return dao.getAllPatients();
    }

    public LiveData<PatientEntity> getPatient(long id) {
        return dao.getPatientById(id);
    }

    public void insert(PatientEntity p) {
        io.execute(() -> dao.insertPatient(p));
    }
}

