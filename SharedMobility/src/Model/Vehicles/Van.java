package Model.Vehicles;
//modifica
import Model.DrivingLicense;
import Model.Vehicle;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;
@Getter
public class Van extends Vehicle {
    private String plate;
    private DrivingLicense drivingLicense;

    public Van(@NonNull UUID ID, @NonNull String geo,
                  double rateXMinute,String plate,DrivingLicense drivingLicense) {
        super(ID, geo, rateXMinute);
        this.plate = plate;
        this.drivingLicense = drivingLicense;
    }

    public Van(@NonNull UUID ID, @NonNull String geo, UUID userID, double rateXMinute, String plate, DrivingLicense drivingLicense) {
        super(ID, geo, userID, rateXMinute);
        this.plate = plate;
        this.drivingLicense = drivingLicense;
    }
}
