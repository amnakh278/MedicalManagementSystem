package data.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "appointments",
        foreignKeys = {
                @ForeignKey(entity = PatientEntity.class,
                        parentColumns = "patientId",
                        childColumns  = "patientId",
                        onDelete      = ForeignKey.CASCADE),
                @ForeignKey(entity = DoctorEntity.class,
                        parentColumns = "doctorId",
                        childColumns  = "doctorId",
                        onDelete      = ForeignKey.CASCADE)
        }
)
public class
AppointmentEntity {
    @PrimaryKey(autoGenerate = true)
    private long appointmentId;
    private long patientId;
    private long doctorId;
    private Date date;
    private String status;



}
