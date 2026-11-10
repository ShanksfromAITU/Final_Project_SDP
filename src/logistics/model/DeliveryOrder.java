package logistics.model;

import logistics.builder.DeliveryOrderBuilder;

public class DeliveryOrder {
    private final String sender;
    private final String receiver;
    private final String origin;
    private final String destination;
    private final double weight;

    public DeliveryOrder(DeliveryOrderBuilder builder) {
        this.sender = builder.getSender();
        this.receiver = builder.getReceiver();
        this.origin = builder.getOrigin();
        this.destination = builder.getDestination();
        this.weight = builder.getWeight();

        if (isEmpty(sender) || isEmpty(receiver)
                || isEmpty(origin) || isEmpty(destination)) {
            throw new IllegalArgumentException(
                    "Sender, receiver and addresses are required."
            );
        }

        if (!Double.isFinite(weight) || weight <= 0) {
            throw new IllegalArgumentException(
                    "Weight must be a positive finite number."
            );
        }
    }

    private static boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Sender: " + sender
                + "\nReceiver: " + receiver
                + "\nRoute: " + origin + " -> " + destination
                + "\nWeight: " + weight + " kg";
    }
}