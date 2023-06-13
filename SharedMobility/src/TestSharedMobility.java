import Dao.DaoUser;
import Dao.DaoVehicle;
import Dao.implement.DaoUserCsv;
import Dao.implement.DaoVehicleCsv;
import Model.DrivingLicense;
import Model.Helmet;
import Model.User;
import Model.Vehicle;
import Model.Vehicles.*;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TestSharedMobility {
    public static void main(String[] args) {
        DaoUser daoUser = new DaoUserCsv(Paths.get("SharedMobility","src","Dao","implement","users.csv"));
        daoUser.insert(new User(UUID.fromString("4e23ad1c-fc29-45dc-a4e6-f77b969758c8"),"Mario","Rossi", LocalDate.parse("2000-10-05"),"c3d4", List.of(DrivingLicense.B,DrivingLicense.BSPECIAL),false,100));
        daoUser.insert(new User(UUID.randomUUID(),"Gaspare","Bianchi", LocalDate.parse("1999-09-04"),"c3d4", List.of(DrivingLicense.A,DrivingLicense.ASPECIAL),true,1000));
        daoUser.insert(new User(UUID.randomUUID(),"Ilario","Verdi", LocalDate.parse("1998-08-03"),"c3d4", List.of(DrivingLicense.C,DrivingLicense.CSPECIAL),false,10));

        DaoVehicle daoVehicle = new DaoVehicleCsv(Paths.get("SharedMobility", "src", "Dao","implement","vehicles.csv"));
        Vehicle veicolo1= new Car(UUID.randomUUID(), "Milano", 2,"plate", DrivingLicense.B);
        Vehicle veicolo2= new Bicycle(UUID.randomUUID(), "Torino",0.5, Helmet.BIKE);
        Vehicle veicolo3 = new MotoScooter(UUID.randomUUID(), "Genova",1, "plate", DrivingLicense.A);
        Vehicle veicolo4 = new Scooter(UUID.randomUUID(), "Roma",1, Helmet.MOTOSCOOTER);
        Vehicle veicolo5 = new Van(UUID.randomUUID(), "Roma",3, "plate", DrivingLicense.C);



        System.out.println(daoUser.getAll());
        System.out.println("ciao");

    }
}
