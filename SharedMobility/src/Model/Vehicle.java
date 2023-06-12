package Model;

import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;
@Getter
public abstract class Vehicle {
    @NonNull
    private UUID ID;
    @NonNull
    private String geo;
    @NonNull
    private boolean isAvailable;
    private int fuelStatus = 100;
    private double rateXMinute;

    public Vehicle(@NonNull UUID ID, @NonNull String geo, @NonNull boolean isAvailable, double rateXMinute) {
        this.ID = ID;
        this.geo = geo;
        this.isAvailable = isAvailable;
        this.rateXMinute = rateXMinute;
    }
}
