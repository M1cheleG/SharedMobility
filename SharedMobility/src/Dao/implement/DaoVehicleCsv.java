package Dao.implement;

import Dao.DaoVehicle;
import Model.DrivingLicense;
import Model.Helmet;
import Model.Vehicle;
import Model.Vehicles.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DaoVehicleCsv implements DaoVehicle {

    private Path vehicleCsv;
    private TreeMap<UUID, Vehicle> idsToVehicle;

    public DaoVehicleCsv(Path vehicleCsv) {
        this.vehicleCsv = vehicleCsv;
        this.idsToVehicle= new TreeMap<>();

        try {
            if(!Files.exists(vehicleCsv)) {
                Files.createFile(vehicleCsv);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br =Files.newBufferedReader(vehicleCsv)){
            String line;
            while ((line= br.readLine())!=null) {
                String[] values =line.split(":");
                Vehicle vehicle=null;

                switch (values[5]){
                    case "Bicycle":
                            vehicle= new Bicycle(UUID.fromString(values[0]),values[1],values[2],Integer.valueOf(values[3]),Double.valueOf(values[4]), Helmet.valueOf(values[6]));
                        break;
                    case "Car":
                        vehicle= new Car(UUID.fromString(values[0]),values[1],values[2],Integer.valueOf(values[3]),Double.valueOf(values[4]),values[6], DrivingLicense.valueOf(values[7]));
                        break;
                    case "MotoScooter":
                        vehicle= new MotoScooter(UUID.fromString(values[0]),values[1],values[2],Integer.valueOf(values[3]),Double.valueOf(values[4]),values[6], DrivingLicense.valueOf(values[7]));
                        break;
                    case "Scooter":
                        vehicle= new Scooter(UUID.fromString(values[0]),values[1],values[2],Integer.valueOf(values[3]),Double.valueOf(values[4]), Helmet.valueOf(values[6]));
                        break;
                    case "Van":
                        vehicle= new Van(UUID.fromString(values[0]),values[1],values[2],Integer.valueOf(values[3]),Double.valueOf(values[4]),values[6], DrivingLicense.valueOf(values[7]));
                }

                this.idsToVehicle.put(UUID.fromString(values[0]),vehicle);

                /*
                if(values[5]=="Bicycle"){
                    vehicle= new Bicycle(UUID.fromString(values[1]),values[2],UUID.fromString(values[3]),Double.valueOf(values[4]), Helmet.valueOf(values[5]));
                }else if(values[5]=="Car"){
                    vehicle= new Car(UUID.fromString(values[1]),values[2],UUID.fromString(values[3]),Double.valueOf(values[4]),values[5], DrivingLicense.valueOf(values[6]));
                }else if(values[5]=="MotoScooter") {
                    vehicle= new MotoScooter(UUID.fromString(values[1]),values[2],UUID.fromString(values[3]),Double.valueOf(values[4]),values[5], DrivingLicense.valueOf(values[6]));
                } else if (values[5]=="Scooter") {
                    vehicle= new Scooter(UUID.fromString(values[1]),values[2],UUID.fromString(values[3]),Double.valueOf(values[4]), Helmet.valueOf(values[5]));
                } else{
                    vehicle= new Van(UUID.fromString(values[1]),values[2],UUID.fromString(values[3]),Double.valueOf(values[4]),values[5], DrivingLicense.valueOf(values[6]));
                }
                this.idsToVehicle.put(UUID.fromString(values[1]),vehicle);
            */
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean insert(Vehicle vehicle) {
        this.idsToVehicle.put(vehicle.getID(),vehicle);
        return save();
    }

    @Override
    public boolean update(Vehicle vehicle) {
        this.idsToVehicle.put(vehicle.getID(),vehicle);
        return save();
    }

    @Override
    public boolean delete(Vehicle vehicle) {
        Vehicle removedVehicle = idsToVehicle.remove(vehicle.getID());

        if(removedVehicle!=null) {
            return save();
        }else{
                return false;
            }

    }

    @Override
    public Vehicle get(UUID id) {
        return idsToVehicle.get(id);
    }

    @Override
    public List<Vehicle> getAll() {
        return new ArrayList<>(idsToVehicle.values());
    }

    public boolean save(){
        try (BufferedWriter bw = Files.newBufferedWriter(this.vehicleCsv)) {
            for (Vehicle vehicle : idsToVehicle.values()) {
                List<String> values = new ArrayList();
                List<String> temp=Arrays.asList(
                        vehicle.getID().toString(),
                        vehicle.getGeo(),
                        vehicle.getUserID()!=null?vehicle.getUserID().toString():null,
                        Integer.toString(vehicle.getFuelStatus()),
                        Double.toString(vehicle.getRateXMinute()));
                values.addAll(temp);

                switch (vehicle.getClass().getSimpleName()){
                    case "Bicycle":
                        values.add("Bicycle");
                        values.add(((Bicycle) vehicle).getHelmet().toString());
                        break;
                    case "Car":
                        values.add("Car");
                        values.add(((Car) vehicle).getPlate());
                        values.add(String.valueOf(((Car) vehicle).getDrivingLicense()));
                        break;
                    case "MotoScooter":
                        values.add("MotoScooter");
                        values.add(((MotoScooter) vehicle).getPlate());
                        values.add(String.valueOf(((MotoScooter) vehicle).getDrivingLicense()));
                        break;
                    case "Scooter":
                        values.add("Scooter");
                        values.add(((Scooter) vehicle).getHelmet().toString());
                        break;
                    case "Van":
                        values.add("Van");
                        values.add(((Van) vehicle).getPlate());
                        values.add(String.valueOf(((Van) vehicle).getDrivingLicense()));
                }

                /*if(vehicle instanceof Bicycle){
                    values.add("Bicycle");
                    values.add(((Bicycle) vehicle).getHelmet().toString());
                }else if(vehicle instanceof Car) {
                    values.add("Car");
                    values.add(((Car) vehicle).getPlate());
                    values.add(String.valueOf(((Car) vehicle).getDrivingLicense()));
                }else if(vehicle instanceof MotoScooter) {
                    values.add("MotoScooter");
                    values.add(((MotoScooter) vehicle).getPlate());
                    values.add(String.valueOf(((MotoScooter) vehicle).getDrivingLicense()));
                } else if (vehicle instanceof Scooter) {
                    values.add("Scooter");
                    values.add(((Scooter) vehicle).getHelmet().toString());
                } else if (vehicle instanceof Van) {
                    values.add("Van");
                    values.add(((Van) vehicle).getPlate());
                    values.add(String.valueOf(((Van) vehicle).getDrivingLicense()));
                }*/


                bw.write(String.join(":", values));
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }



        return false;
    }
}
/* if(vehicle instanceof Bicycle){
                }else if(vehicle instanceof Car){
                }else if(vehicle instanceof MotoScooter) {
                } else if (vehicle instanceof Scooter) {
                } else if (vehicle instanceof Van) {

                } */