package Model.Vehicles;
//modifica
import Model.DrivingLicense;
import Model.Vehicle;
import lombok.NonNull;

import java.util.UUID;

public class Van extends Vehicle {
    private String dio ="Syncron polverizzazione";
    private String plate;
    private DrivingLicense drivingLicense;

    protected Van(@NonNull UUID ID, @NonNull String geo, @NonNull boolean isAvailable,
                  double rateXMinute,String plate,DrivingLicense drivingLicense) {
        super(ID, geo, isAvailable, rateXMinute);
        this.plate = plate;
        this.drivingLicense = drivingLicense;
    }
}
