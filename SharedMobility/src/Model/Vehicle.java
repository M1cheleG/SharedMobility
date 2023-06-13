package Model;

import lombok.Getter;
import lombok.NonNull;

import java.util.Collection;
import java.util.UUID;
@Getter
public abstract class  Vehicle {
    @NonNull
    private UUID ID;
    @NonNull
    private String geo;
    @NonNull
    private UUID userID;
    private int fuelStatus = 100;
    private double rateXMinute;

    protected Vehicle(@NonNull UUID ID, @NonNull String geo, double rateXMinute) {
        this.ID = ID;
        this.geo = geo;
        this.rateXMinute = rateXMinute;
        this.userID = null;
    }


    public void setUser(User user) {
    }
}
