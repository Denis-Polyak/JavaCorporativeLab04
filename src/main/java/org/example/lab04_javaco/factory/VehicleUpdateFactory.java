package org.example.lab04_javaco.factory;

import org.example.lab04_javaco.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleUpdateFactory {

    public void updateVehicle(Vehicle existingVehicle, Vehicle vehicleDetails) {
        existingVehicle.setVehicleModel(vehicleDetails.getVehicleModel());
        existingVehicle.setRegistrationNumber(vehicleDetails.getRegistrationNumber());
        existingVehicle.setYearOfManufacture(vehicleDetails.getYearOfManufacture());
        existingVehicle.setVehicleLength(vehicleDetails.getVehicleLength());
        existingVehicle.setVehicleWidth(vehicleDetails.getVehicleWidth());
        existingVehicle.setVehicleHeight(vehicleDetails.getVehicleHeight());
        existingVehicle.setColor(vehicleDetails.getColor());
        existingVehicle.setWeightEmpty(vehicleDetails.getWeightEmpty());
        existingVehicle.setWeightLoaded(vehicleDetails.getWeightLoaded());
        existingVehicle.setDriver(vehicleDetails.getDriver());
        existingVehicle.setOwner(vehicleDetails.getOwner());
        existingVehicle.setTechnicalCondition(vehicleDetails.getTechnicalCondition());
        existingVehicle.setTrailer(vehicleDetails.getTrailer());
    }
}

