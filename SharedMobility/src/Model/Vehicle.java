package Model;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Collection;
import java.util.UUID;
@Getter
@ToString
public abstract class  Vehicle {
    @NonNull
    private UUID ID;
    @NonNull
    private String geo;
    private UUID userID;
    private int fuelStatus = 100;
    private double rateXMinute;

    public Vehicle(@NonNull UUID ID, @NonNull String geo, double rateXMinute) {
        this.ID = ID;
        this.geo = geo;
        this.rateXMinute = rateXMinute;
        this.userID = null;
    }
    protected Vehicle(@NonNull UUID ID, @NonNull String geo,String userID,int fuelStatus, double rateXMinute) {
        this.ID = ID;
        this.geo = geo;
        this.rateXMinute = rateXMinute;
        this.fuelStatus=fuelStatus;
        if(userID.equals("null")){
            this.userID=null;
        }else{
            this.userID = UUID.fromString(userID);
        }
    }
    public void setUserID(UUID userID) {
        this.userID = userID;
    }
}
