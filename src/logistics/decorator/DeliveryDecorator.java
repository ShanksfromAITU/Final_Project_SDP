package logistics.decorator;

import java.util.Objects;

public abstract class DeliveryDecorator implements DeliveryService {
    protected final DeliveryService wrapped;

    protected DeliveryDecorator(DeliveryService wrapped) {
        this.wrapped = Objects.requireNonNull(
                wrapped, "Delivery service is required."
        );
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription();
    }

    @Override
    public double getCost() {
        return wrapped.getCost();
    }
}
