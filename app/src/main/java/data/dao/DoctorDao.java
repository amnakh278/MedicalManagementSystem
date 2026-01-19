package data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import data.entities.DoctorEntity;
import java.util.List;

@Dao
public interface DoctorDao {

    @Insert
    long insertDoctor(DoctorEntity doctor);

    @Query("SELECT * FROM doctors WHERE doctorId = :id")
    LiveData<DoctorEntity> getDoctorById(long id);

    @Query("SELECT * FROM doctors")
    LiveData<List<DoctorEntity>> getAllDoctors();
}
