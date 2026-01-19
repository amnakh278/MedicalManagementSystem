package data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import data.entities.AppointmentEntity;
import java.util.Date;
import java.util.List;

@Dao
public interface AppointmentDao {
    @Insert
    long insertAppointment(AppointmentEntity appt);

    @Query("SELECT * FROM appointments WHERE patientId = :pid")
    LiveData<List<AppointmentEntity>> getAppointmentsForPatient(long pid);

    @Query("SELECT * FROM appointments WHERE doctorId = :did AND status = 'PENDING'")
    LiveData<List<AppointmentEntity>> getPendingAppointments(long did);

    @Query("SELECT * FROM appointments WHERE doctorId = :did AND date = :today")
    LiveData<List<AppointmentEntity>> getTodaysAppointments(long did, Date today);
}
