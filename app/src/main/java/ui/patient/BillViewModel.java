package ui.patient;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import data.BillRepository;
import data.entities.BillEntity;
import java.util.List;

public class BillViewModel extends AndroidViewModel {
    private final BillRepository repo;
    public BillViewModel(@NonNull Application app) {
        super(app);
        repo = new BillRepository(app);
    }
    public LiveData<List<BillEntity>> getBillsForPatient(long pid) {
        return repo.getBillsForPatient(pid);
    }
}
