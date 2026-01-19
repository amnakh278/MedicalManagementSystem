
package data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patients")
public class PatientEntity {

    @PrimaryKey(autoGenerate = true)
    private long patientId;

    private String name;
    private int age;
    private String gender;
    private String contact;

    // Public no-arg constructor for Room
    public PatientEntity() { }

    // Convenience constructor
    public PatientEntity(String name, int age, String gender, String contact) {
        this.name    = name;
        this.age     = age;
        this.gender  = gender;
        this.contact = contact;
    }

    // Getters
    public long   getPatientId() { return patientId; }
    public String getName()      { return name;      }
    public int    getAge()       { return age;       }
    public String getGender()    { return gender;    }
    public String getContact()   { return contact;   }

    // **Setters** (required by Room for each private field)
    public void setPatientId(long patientId) { this.patientId = patientId; }
    public void setName(String name)         { this.name      = name;      }
    public void setAge(int age)              { this.age       = age;       }
    public void setGender(String gender)     { this.gender    = gender;    }
    public void setContact(String contact)   { this.contact   = contact;   }
}
