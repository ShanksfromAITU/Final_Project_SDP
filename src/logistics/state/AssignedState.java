package logistics.state;

public class AssignedState implements DeliveryState {
    @Override
    public String getName() {
        return "Assigned";
    }

    @Override
    public void dispatch(Delivery delivery) {
        delivery.changeState(new InTransitState());
    }
}