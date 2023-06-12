package Model.Vehicles;

import Model.Helmet;
import Model.Vehicle;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;
@Builder
@Getter
@Setter
public class Scooter extends Vehicle {

    private Helmet helmet;

    public Scooter(@NonNull UUID ID, @NonNull String geo, @NonNull boolean isAvailable, double rateXMinute,Helmet helmet) {
        super(ID, geo, isAvailable, rateXMinute);
        this.helmet = helmet;
    }
    /*  public static class ScooterBuilder{
        private Helmet helmet;

        private DrivingLicense drivingLicense;
    }
*/
}
