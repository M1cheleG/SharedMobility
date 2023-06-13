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

    protected Van(@NonNull UUID ID, @NonNull String geo,
                  double rateXMinute,String plate,DrivingLicense drivingLicense) {
        super(ID, geo, rateXMinute);
        this.plate = plate;
        this.drivingLicense = drivingLicense;
    }
}
