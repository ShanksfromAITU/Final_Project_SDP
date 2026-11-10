package logistics.builder;

import logistics.model.DeliveryOrder;

public class DeliveryOrderBuilder {
    private String sender;
    private String receiver;
    private String origin;
    private String destination;
    private double weight;

    public DeliveryOrderBuilder sender(String sender) {
        this.sender = sender;
        return this;
    }

    public DeliveryOrderBuilder receiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public DeliveryOrderBuilder origin(String origin) {
        this.origin = origin;
        return this;
    }

    public DeliveryOrderBuilder destination(String destination) {
        this.destination = destination;
        return this;
    }

    public DeliveryOrderBuilder weight(double weight) {
        this.weight = weight;
        return this;
    }

    public DeliveryOrder build() {
        return new DeliveryOrder(this);
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
}
