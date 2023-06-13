package Model.Vehicles;

import Model.Helmet;
import Model.Vehicle;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;
//@Builder
@Getter
@Setter
public class Scooter extends Vehicle {

    private Helmet helmet;

    public Scooter(@NonNull UUID ID, @NonNull String geo, double rateXMinute,Helmet helmet) {
        super(ID, geo, rateXMinute);
        this.helmet = helmet;
    }

    public Scooter(@NonNull UUID ID, @NonNull String geo, String userID, int fuelStatus, double rateXMinute, Helmet helmet) {
        super(ID, geo, userID, fuelStatus, rateXMinute);
        this.helmet = helmet;
    }
}
