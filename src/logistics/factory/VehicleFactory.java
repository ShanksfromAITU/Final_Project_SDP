package logistics.factory;

import logistics.model.Vehicle;

public abstract class VehicleFactory {
    public abstract Vehicle createVehicle(String plateNumber);
}