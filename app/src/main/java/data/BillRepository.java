package data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import data.dao.BillDao;
import data.entities.BillEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class BillRepository {
    private final BillDao dao;
    private final ExecutorService io;

    public BillRepository(Context ctx) {
        AppDatabase db = AppDatabase.getInstance(ctx);
        dao = db.billDao();
        io  = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<BillEntity>> getBillsForPatient(long pid) {
        return dao.getBillsForPatient(pid);
    }

    public void insert(BillEntity bill) {
        io.execute(() -> dao.insertBill(bill));
    }
}
