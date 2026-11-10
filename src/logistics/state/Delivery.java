package logistics.state;

import logistics.model.DeliveryOrder;
import logistics.model.Vehicle;
import logistics.observer.DeliveryObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Delivery {
    private final DeliveryOrder order;
    private final List<DeliveryObserver> observers = new ArrayList<>();

    private DeliveryState state;
    private Vehicle vehicle;

    public Delivery(DeliveryOrder order) {
        this.order = Objects.requireNonNull(
                order, "Order is required."
        );
        this.state = new CreatedState();
    }

    public void addObserver(DeliveryObserver observer) {
        Objects.requireNonNull(observer, "Observer is required.");

        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(DeliveryObserver observer) {
        observers.remove(observer);
    }

    public void assignVehicle(Vehicle vehicle) {
        state.assignVehicle(this, vehicle);
    }

    public void dispatch() {
        state.dispatch(this);
    }

    public void complete() {
        state.complete(this);
    }

    // Package-private: only classes in logistics.state can call these.
    void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    void changeState(DeliveryState nextState) {
        Objects.requireNonNull(nextState, "State is required.");

        String previousStatus = state.getName();
        state = nextState;

        String message = order.getOrigin()
                + " -> " + order.getDestination()
                + ": " + previousStatus
                + " -> " + state.getName();

        notifyObservers(message);
    }

    private void notifyObservers(String message) {
        for (DeliveryObserver observer : List.copyOf(observers)) {
            observer.update(message);
        }
    }

    public DeliveryOrder getOrder() {
        return order;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getStatus() {
        return state.getName();
    }
}