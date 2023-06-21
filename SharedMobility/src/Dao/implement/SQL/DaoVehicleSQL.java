package Dao.implement.SQL;

import Dao.DaoVehicle;
import Model.DrivingLicense;
import Model.Vehicle;
import Model.Vehicles.*;
import connection_handler.ConnectionHandler;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class DaoVehicleSQL implements DaoVehicle {
    @Override
    public boolean insert(Vehicle vehicle) {
        int insertCount=0;
        try {
            String query ="INSERT INTO shared_mobility.vehicle( ID, geo, user_id, fuel_status, rateXminute, type, helmet, plate, drivinglicense) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ConnectionHandler connectionHandler = ConnectionHandler.getInstance();
            PreparedStatement ps = connectionHandler.getPreparedStatement(query);

            ps.setString(1,vehicle.getID().toString());
            ps.setString(2,vehicle.getGeo());
            ps.setString(3,vehicle.getUserID().toString());
            ps.setInt(4, vehicle.getFuelStatus());
            ps.setDouble(5,vehicle.getRateXMinute());

            switch (vehicle.getClass().getSimpleName()){
                case "Bicycle":
                    ps.setString(6,"Bicycle");
                    ps.setString(7,((Bicycle) vehicle).getHelmet().toString());
                    break;
                case "Car":
                    ps.setString(6,"Car");
                    ps.setString(8,(((Car) vehicle).getPlate()));
                    ps.setString(9,String.valueOf(((Car) vehicle).getDrivingLicense()));
                    break;
                case "MotoScooter":
                    ps.setString(6,"MotoScooter");
                    ps.setString(8,(((MotoScooter) vehicle).getPlate()));
                    ps.setString(9,String.valueOf(((MotoScooter) vehicle).getDrivingLicense()));
                    break;
                case "Scooter":
                    ps.setString(6,"Scooter");
                    ps.setString(7,((Scooter) vehicle).getHelmet().toString());
                    break;
                case "Van":
                    ps.setString(6,"Van");
                    ps.setString(8,(((Van) vehicle).getPlate()));
                    ps.setString(9,String.valueOf(((Van) vehicle).getDrivingLicense()));
            }

            insertCount= ps.executeUpdate();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return insertCount > 0;
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

    @Override
    public List<Vehicle> getAll() {
        return null;
    }
}
