package Model;

import java.util.ArrayList;
import java.util.List;

public class ShareMobility {
    private List<User> users;
    private List<Vehicle> vehicles;

    public ShareMobility(List<User> users, List<Vehicle> vehicles) {
        this.users = users;
        this.vehicles = vehicles;
    }

    public void signinUser(User user) {
        users.add(user);
    }

    public List<Vehicle> searchVehicle() {

        return null;
    }

    public void rentVehicle(Vehicle vehicle, User user) {
        if (vehicle.isAvailable()) {
            vehicle.setAvailable(false);
            vehicle.getUsersWhoRented().add(user);
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
    }
}
