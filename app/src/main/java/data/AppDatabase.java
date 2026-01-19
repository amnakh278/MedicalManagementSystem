package data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import data.dao.*;
import data.entities.*;
import util.DateConverters;

@Database(
        entities = {
                PatientEntity.class,
                DoctorEntity.class,
                AppointmentEntity.class,
                BillEntity.class,
                TreatmentEntity.class
        },
        version = 1,
        exportSchema = false
)
@TypeConverters(DateConverters.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PatientDao patientDao();
    public abstract DoctorDao doctorDao();
    public abstract AppointmentDao appointmentDao();
    public abstract BillDao billDao();
    public abstract TreatmentDao treatmentDao();

    private static volatile AppDatabase INSTANCE;
    public static AppDatabase getInstance(Context ctx) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(ctx.getApplicationContext(),
                                    AppDatabase.class, "med_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

