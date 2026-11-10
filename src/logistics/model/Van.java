package logistics.model;

public class Van extends Vehicle {
    public Van(String plateNumber) {
        super(plateNumber, 1000);
    }

    @Override
    public String getType() {
        return "Van";
    }
}