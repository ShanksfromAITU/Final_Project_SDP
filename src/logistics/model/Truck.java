package logistics.model;

public class Truck extends Vehicle {
    public Truck(String plateNumber) {
        super(plateNumber, 10000);
    }

    @Override
    public String getType() {
        return "Truck";
    }
}