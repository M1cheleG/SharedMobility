import Model.DrivingLicense;
import Model.Helmet;
import Model.User;
import Model.Vehicle;
import Model.Vehicles.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TestSharedMobility {
    public static void main(String[] args) {
        SharedMobility app = new SharedMobility();
        User user1=new User(UUID.fromString("4e23ad1c-fc29-45dc-a4e6-f77b969758c8"),"Mario","Rossi", LocalDate.parse("2000-10-05"),"c3d4", List.of(DrivingLicense.B,DrivingLicense.BSPECIAL),Helmet.SCOOTER,100);
        User user2=new User(UUID.fromString("9637a735-86b4-42d2-9559-a06be12a6d4a"),"Ilario","Verdi", LocalDate.parse("1998-08-03"),"c3d4", List.of(DrivingLicense.C,DrivingLicense.CSPECIAL),Helmet.SCOOTER,10);
        User user3=new User(UUID.fromString("961f8d13-eedb-4303-b254-fd02c2aed2eb"),"Gaspare","Bianchi", LocalDate.parse("1999-09-04"),"c3d4", List.of(DrivingLicense.A,DrivingLicense.ASPECIAL),Helmet.SCOOTER,1000);


        /*
        app.signinUser(user1);
        app.signinUser(user2);
        app.signinUser(user3); */

        Vehicle veicolo1= new Car(UUID.fromString("84f0b1aa-3300-4736-bdb4-b12438fd1005"), "Milano", 2,"plate", DrivingLicense.B);
        Vehicle veicolo2= new Bicycle(UUID.fromString("86a2bdb9-57fc-411d-882d-17471c36d85c"), "Torino",0.5, Helmet.BIKE);
        Vehicle veicolo3 = new MotoScooter(UUID.fromString("8edcea47-ca13-4a50-8360-698abb0ae341"), "Genova",1, "plate", DrivingLicense.A);
        Vehicle veicolo4 = new Scooter(UUID.fromString("2d5ab7b5-2c92-4525-8a1d-f13a2102304e"), "Roma",1, Helmet.SCOOTER);
        Vehicle veicolo5 = new Van(UUID.fromString("5a947054-ff14-4475-8b5d-ceaeeb79d4c3"), "Roma",3, "plate", DrivingLicense.C);

        /*
        app.addVehicle(veicolo1);
        app.addVehicle(veicolo2);
        app.addVehicle(veicolo3);
        app.addVehicle(veicolo4);
        app.addVehicle(veicolo5); */


        app.addCreditUser(user3,150);
        app.returnVehicle(veicolo4);
        app.rentVehicle(veicolo4,user3,151);
        System.out.println("ciao");

    }
}
