package logistics.state;

import logistics.model.Vehicle;

public interface DeliveryState {
    String getName();

    default void assignVehicle(Delivery delivery, Vehicle vehicle) {
        throw new IllegalStateException(
                "Cannot assign a vehicle in state: " + getName()
        );
    }

    default void dispatch(Delivery delivery) {
        throw new IllegalStateException(
                "Cannot dispatch in state: " + getName()
        );
    }

    default void complete(Delivery delivery) {
        throw new IllegalStateException(
                "Cannot complete in state: " + getName()
        );
    }
}