package logistics.factory;

import logistics.model.Truck;
import logistics.model.Vehicle;

public class TruckFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String plateNumber) {
        return new Truck(plateNumber);
    }
}