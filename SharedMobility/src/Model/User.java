package Model;

import lombok.Getter;
import lombok.NonNull;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter
public class User {
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private Date dateOfBirth;
    @NonNull
    private String CF;
    @NonNull
    private UUID ID;
    private List<DrivingLicense> DrivingLicenses;
    private boolean helmet;
    private double credit = 0;

    public User(@NonNull String name, @NonNull String surname, @NonNull Date dateOfBirth,
                @NonNull String CF, @NonNull UUID ID, List<DrivingLicense> drivingLicenses, boolean helmet) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.CF = CF;
        this.ID = ID;
        this.DrivingLicenses = drivingLicenses;     //va bene?
        this.helmet = helmet;
    }
}
