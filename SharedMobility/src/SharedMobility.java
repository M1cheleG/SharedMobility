
import Model.*;

import java.util.ArrayList;
import java.util.List;

public class SharedMobility {
    private DB database;

    public SharedMobility(DB database) {
        this.database = database;
    }

    public void signinUser(User user) {
        database.addUser(user);
    }

    public List<Vehicle> searchVehicle() {

        return null;
    }

   /* public void rentVehicle(Vehicle vehicle, User user) {
        if (vehicle.isAvailable()) {
            vehicle.setAvailable(false);
            //vehicle.getUsersWhoRented().add(user);
        } else {
            System.out.println("Il veicolo non è disponibile per l'affitto.");
        }
    }

    public void returnVehicle(Vehicle vehicle, User user) {
        if (vehicle.getUsersWhoRented().contains(user)) {
            vehicle.setAvailable(true);
            vehicle.getUsersWhoRented().remove(user);
        } else {
            System.out.println("L'utente non ha affittato questo veicolo.");
        }
    } */

}
