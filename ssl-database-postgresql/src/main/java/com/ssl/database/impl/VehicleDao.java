package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.IDataAccessObject;
import com.ssl.database.IVehicleDao;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.Vehicle;

@Component
@Repository
public class VehicleDao implements IVehicleDao
{

    private static final Log log = LogFactory.getLog(VehicleDao.class);

    @Autowired
    private IDataAccessObject<Vehicle> vehicleDataAcessObject;

    @PostConstruct
    public void initVehicleDao()
    {
        log.debug("Initializing generic repository access");
        this.vehicleDataAcessObject.setClassType(Vehicle.class);
        log.debug("Generic repository with entity :" + Vehicle.class.getName());
    }

    @Override
    public void addVehicle(Vehicle vehicle)
    {
        this.vehicleDataAcessObject.addEntity(vehicle);
    }

    @Override
    public Vehicle getVehicleByID(int id)
    {
        return this.vehicleDataAcessObject.getEntityById(id);
    }

    @Override
    public List<Vehicle> getVehicleByUserId(int userId)
    {
        return this.vehicleDataAcessObject.getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.USER, userId);
    }

    @Override
    public Vehicle getVehicleByPlate(String plate)
    {
        return this.vehicleDataAcessObject.getEntityByEntityColumn(DataBaseColumnQuerysConstants.LICENCE_PLATE, plate);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle)
    {
        return this.vehicleDataAcessObject.updateEntity(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicle)
    {
        this.vehicleDataAcessObject.removeEntity(vehicle);
    }

    @Override
    public void removeVehicleById(int id)
    {
        this.vehicleDataAcessObject.removeEntityById(id);
    }

    @Override
    public void RemoveVehicleByUserId(int userId)
    {
        this.vehicleDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.USER, userId);
    }

}
