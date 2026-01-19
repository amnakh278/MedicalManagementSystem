package data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import data.entities.PatientEntity;
import java.util.List;

@Dao
public interface PatientDao {
    @Insert
    long insertPatient(PatientEntity patient);

    @Query("SELECT * FROM patients WHERE patientId = :id")
    LiveData<PatientEntity> getPatientById(long id);

    @Query("SELECT * FROM patients")
    LiveData<List<PatientEntity>> getAllPatients();
}

