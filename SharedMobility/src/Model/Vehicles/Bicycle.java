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

    public Bicycle(@NonNull UUID ID, @NonNull String geo, @NonNull boolean isAvailable, double rateXMinute,Helmet helmet) {
        super(ID, geo, isAvailable, rateXMinute);
        this.helmet = helmet;
    }
}
