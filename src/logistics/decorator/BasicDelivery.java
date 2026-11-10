package logistics.decorator;

import logistics.model.DeliveryOrder;
import logistics.model.Route;

import java.util.Objects;

public class BasicDelivery implements DeliveryService {
    private final DeliveryOrder order;
    private final Route route;

    public BasicDelivery(DeliveryOrder order, Route route) {
        this.order = Objects.requireNonNull(
                order, "Order is required."
        );
        this.route = Objects.requireNonNull(
                route, "Route is required."
        );
    }

    @Override
    public String getDescription() {
        return "Delivery: " + order.getOrigin()
                + " -> " + order.getDestination()
                + " (" + route.getName() + ")";
    }

    @Override
    public double getCost() {
        return route.getCost();
    }
}
