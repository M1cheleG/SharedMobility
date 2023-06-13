package Model.Vehicles;

import Model.DrivingLicense;
import Model.Vehicle;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;
@Getter
public class MotoScooter extends Vehicle {
    @NonNull
    private String plate;
    @NonNull
    private DrivingLicense drivingLicense;


    protected MotoScooter(@NonNull UUID ID, @NonNull String geo, double rateXMinute,String plate,DrivingLicense drivingLicense) {
        super(ID, geo, rateXMinute);
        this.plate = plate;
        this.drivingLicense = drivingLicense;
    }
}
