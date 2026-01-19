package data;

import android.content.Context;
import androidx.lifecycle.LiveData;
import data.dao.DoctorDao;
import data.entities.DoctorEntity;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DoctorRepository {
    private final DoctorDao dao;
    private final ExecutorService io = Executors.newSingleThreadExecutor();

    public DoctorRepository(Context ctx) {
        AppDatabase db = AppDatabase.getInstance(ctx);
        dao = db.doctorDao();
    }

    public LiveData<DoctorEntity> getDoctor(long id) {
        return dao.getDoctorById(id);
    }

    public LiveData<List<DoctorEntity>> getAllDoctors() {
        return dao.getAllDoctors();
    }

    public void insert(DoctorEntity d) {
        io.execute(() -> dao.insertDoctor(d));
    }
}
