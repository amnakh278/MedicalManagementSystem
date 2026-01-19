package data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import data.entities.BillEntity;

import java.util.List;

@Dao
public interface BillDao {
    // ← this is the insert method your repository expects
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBill(BillEntity bill);

    // ← your text‐block query (converted to a single string)
    @Query(
            "SELECT b.* " +
                    "FROM bills AS b " +
                    "INNER JOIN appointments AS a " +
                    "  ON b.appointmentId = a.appointmentId " +
                    "WHERE a.patientId = :patientId"
    )
    LiveData<List<BillEntity>> getBillsForPatient(long patientId);
}
