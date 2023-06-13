package Model.Vehicles;
import Model.Helmet;
import Model.Vehicle;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Bicycle extends Vehicle {
    private Helmet helmet;

    public Bicycle(@NonNull UUID ID, @NonNull String geo, double rateXMinute,Helmet helmet) {
        super(ID, geo, rateXMinute);
        this.helmet = helmet;
    }

    public Bicycle(@NonNull UUID ID, @NonNull String geo, String userID, int fuelStatus, double rateXMinute, Helmet helmet) {
        super(ID, geo, userID, fuelStatus, rateXMinute);
        this.helmet = helmet;
    }
}
