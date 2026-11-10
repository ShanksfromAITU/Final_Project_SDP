package logistics.state;

public class InTransitState implements DeliveryState {
    @Override
    public String getName() {
        return "InTransit";
    }

    @Override
    public void complete(Delivery delivery) {
        delivery.getVehicle().release();
        delivery.changeState(new DeliveredState());
    }
}