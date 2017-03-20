package com.ssl.database;

import java.util.List;

import com.ssl.entities.Vehicle;

public interface IVehicleDao
{
    void addVehicle(Vehicle vehicle);

    Vehicle getVehicleByID(int id);

    List<Vehicle> getVehicleByUserId(int userId);

    Vehicle getVehicleByPlate(String plate);
    
    Vehicle updateVehicle(Vehicle vehicle);

    void removeVehicleById(int id);

    void RemoveVehicleByUserId(int userId);

    void removeVehicle(Vehicle vehicle);
}
