package Model.Vehicles;

import Model.DrivingLicense;
import Model.Vehicle;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;
@Getter
public class Car extends Vehicle {
    private String plate;
    private DrivingLicense drivingLicense;

    public Car(@NonNull UUID ID, @NonNull String geo, double rateXMinute,String plate,DrivingLicense drivingLicense) {
        super(ID, geo, rateXMinute);
        this.plate = plate;
        this.drivingLicense = drivingLicense;
    }

    public Car(@NonNull UUID ID, @NonNull String geo, String userID, int fuelStatus, double rateXMinute, String plate, DrivingLicense drivingLicense) {
        super(ID, geo, userID, fuelStatus, rateXMinute);
        this.plate = plate;
        this.drivingLicense = drivingLicense;
    }
}
