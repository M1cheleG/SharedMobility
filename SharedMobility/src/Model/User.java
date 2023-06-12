package Model;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter
public class User {

    @NonNull
    private UUID ID;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private LocalDate dateOfBirth;
    @NonNull
    private String CF;
    private List<DrivingLicense> DrivingLicenses;
    private boolean helmet;
    private double credit = 0;

    public User(@NonNull UUID ID, @NonNull String name, @NonNull String surname, @NonNull LocalDate dateOfBirth,
                @NonNull String CF,  List<DrivingLicense> drivingLicenses, boolean helmet, double credit) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.CF = CF;
        this.ID = ID;
        this.DrivingLicenses = drivingLicenses;     //va bene?
        this.helmet = helmet;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", CF='" + CF + '\'' +
                ", DrivingLicenses=" + DrivingLicenses +
                ", helmet=" + helmet +
                ", credit=" + credit +
                '}';
    }
}
