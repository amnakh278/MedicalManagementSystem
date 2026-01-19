
package data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "doctors")
public class DoctorEntity {
    @PrimaryKey(autoGenerate = true)
    private long doctorId;
    private String name;
    private String specialization;
    private String contact;

    // 1) Add this constructor so you can new DoctorEntity(name, spec, contact)
    public DoctorEntity(String name, String specialization, String contact) {
        this.name = name;
        this.specialization = specialization;
        this.contact = contact;
    }

    // 2) A no-arg constructor for Room (optional but recommended)
    public DoctorEntity() { }

    // 3) Getters & setters
    public long getDoctorId() { return doctorId; }
    public void setDoctorId(long id) { this.doctorId = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
