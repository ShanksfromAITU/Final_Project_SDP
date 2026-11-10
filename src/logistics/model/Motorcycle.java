package logistics.model;

public class Motorcycle extends Vehicle {
    public Motorcycle(String plateNumber) {
        super(plateNumber, 20);
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }
}