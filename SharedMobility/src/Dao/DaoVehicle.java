package Dao;

import Model.Vehicle;

import java.util.UUID;

public interface DaoVehicle {
    boolean insert(Vehicle vehicle);

    boolean update(Vehicle vehicle);

    boolean delete(Vehicle vehicle);

    Vehicle get(UUID id);
}
