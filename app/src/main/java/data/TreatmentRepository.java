package data;

import android.content.Context;
import androidx.lifecycle.LiveData;

import data.dao.TreatmentDao;
import data.entities.TreatmentEntity;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreatmentRepository {
    private final TreatmentDao dao;
    private final ExecutorService io;

    public TreatmentRepository(Context ctx) {
        AppDatabase db = AppDatabase.getInstance(ctx);
        dao = db.treatmentDao();
        io  = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<TreatmentEntity>> getTreatmentsForPatient(long pid) {
        return dao.getTreatmentHistoryForPatient(pid);
    }
    public void insert(TreatmentEntity t) {
        io.execute(() -> dao.insertTreatment(t));
    }
}
