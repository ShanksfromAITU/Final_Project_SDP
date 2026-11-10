package logistics.state;

import logistics.model.Vehicle;
import java.util.Objects;

public class CreatedState implements DeliveryState {
    @Override
    public String getName() {
        return "Created";
    }

    @Override
    public void assignVehicle(Delivery delivery, Vehicle vehicle) {
        Objects.requireNonNull(vehicle, "Vehicle is required.");

        // Checks availability and cargo weight before changing the state.
        vehicle.assign(delivery.getOrder().getWeight());

        delivery.setVehicle(vehicle);
        delivery.changeState(new AssignedState());
    }
}