package data.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "bills",
        foreignKeys = @ForeignKey(entity = AppointmentEntity.class,
                parentColumns = "appointmentId",
                childColumns  = "appointmentId",
                onDelete      = ForeignKey.CASCADE)
)
public class BillEntity {
    @PrimaryKey(autoGenerate = true)
    private long billId;
    private long appointmentId;
    private double amount;
    private Date generatedAt;
    // … constructors, getters/setters …
}

