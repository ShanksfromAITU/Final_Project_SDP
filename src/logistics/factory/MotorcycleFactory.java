package logistics.factory;

import logistics.model.Motorcycle;
import logistics.model.Vehicle;

public class MotorcycleFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String plateNumber) {
        return new Motorcycle(plateNumber);
    }
}