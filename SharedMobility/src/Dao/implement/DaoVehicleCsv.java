package Dao.implement;

import Dao.DaoVehicle;
import Model.User;
import Model.Vehicle;
import Model.Vehicles.*;
import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

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



            }

            }catch (IOException e){
            e.printStackTrace();
        }
        }

    @Override
    public boolean insert(Vehicle vehicle) {

        return false;
    }

    @Override
    public boolean update(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean delete(Vehicle vehicle) {
        return false;
    }

    @Override
    public Vehicle get(UUID id) {
        return null;
    }

    public boolean save(){
        try (BufferedWriter bw = Files.newBufferedWriter(this.vehicleCsv)) {
            for (Vehicle vehicle : idsToVehicle.values()) {
                List<String> values = Arrays.asList(
                        vehicle.getID().toString(),
                        vehicle.getGeo(),
                        Integer.toString(vehicle.getFuelStatus())
                        );

                if(vehicle instanceof Bicycle){
                }else if(vehicle instanceof Car){
                }else if(vehicle instanceof MotoScooter) {
                } else if (vehicle instanceof Scooter) {
                } else if (vehicle instanceof Van) {

                }




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