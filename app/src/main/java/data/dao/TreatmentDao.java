
package data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import data.entities.TreatmentEntity;

import java.util.List;

@Dao
public interface TreatmentDao {

    /** Insert a new treatment (or replace on conflict). */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTreatment(TreatmentEntity treatment);

    /**
     * Returns the completed‐treatment history for a given patient.
     * Assumes TreatmentEntity is annotated with
     *   @Entity(tableName = "treatments")
     * and has a field patientId.
     */
    @Query("SELECT * FROM treatments WHERE patientId = :patientId")
    LiveData<List<TreatmentEntity>> getTreatmentHistoryForPatient(long patientId);
}

