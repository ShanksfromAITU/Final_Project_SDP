package logistics.factory;

import logistics.model.Van;
import logistics.model.Vehicle;

public class VanFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String plateNumber) {
        return new Van(plateNumber);
    }
}