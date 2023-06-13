import Model.*;
import Model.Vehicles.*;

import java.util.List;

public class SharedMobility {
    private DB db;

    public SharedMobility(DB db) {
        this.db = db;
    }

    public void signinUser(User user) {
        db.addUser(user);
    }

    public List<Vehicle> searchVehicle() {
        return db.getAvailableVehicles();
    }

    public void rentVehicle(Vehicle vehicle, User user) {
        // Controllo se il veicolo è disponibile
        if (vehicle.getUserID() != null) {
            System.out.println("Il veicolo non è disponibile.");
            return;
        }

        // Controllo se l'utente è già presente in un altro veicolo
        for (Vehicle v : db.getAllVehicles()) {
            if (v.getUserID() != null && v.getUserID().equals(user.getID())) {
                System.out.println("L'utente è già presente in un altro veicolo.");
                return;
            }
        }

        // Controllo se la patente del veicolo corrisponde alla patente dell'utente
        if (vehicle instanceof Bicycle || vehicle instanceof Scooter) {
            // Bicicletta e Scooter non richiedono una patente
            vehicle.setUserID(user.getID());
            db.updateVehicle(vehicle);
            System.out.println("Veicolo affittato con successo.");
            return;
        } else if (vehicle instanceof Car) {
            // La macchina richiede la patente B o BSSPECIAL
            if (!user.getDrivingLicenses().contains("B") || !user.getDrivingLicenses().contains("BSSPECIAL")) {
                System.out.println("La patente dell'utente non corrisponde alla patente del veicolo.");
                return;
            }
        } else if (vehicle instanceof MotoScooter) {
            // Il MotoScooter richiede la patente A o ASPECIAL
            if (!user.getDrivingLicenses().contains("A") || !user.getDrivingLicenses().contains("ASPECIAL")) {
                System.out.println("La patente dell'utente non corrisponde alla patente del veicolo.");
                return;
            }
        } else if (vehicle instanceof Van) {
            // Il Van richiede la patente C o CSPECIAL
            if (!user.getDrivingLicenses().contains("C") || !user.getDrivingLicenses().contains("CSPECIAL")) {
                System.out.println("La patente dell'utente non corrisponde alla patente del veicolo.");
                return;
            }
        }

        vehicle.setUserID(user.getID());
        db.updateVehicle(vehicle);
        System.out.println("Veicolo affittato con successo.");
    }

    public void returnVehicle(Vehicle vehicle, User user) {
        vehicle.setUserID(null);
        db.updateVehicle(vehicle);
    }
}
