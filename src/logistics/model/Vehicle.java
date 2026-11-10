package logistics.model;

public abstract class Vehicle {
    private final String plateNumber;
    private final double capacity;
    private boolean available = true;

    protected Vehicle(String plateNumber, double capacity) {
        if (plateNumber == null || plateNumber.isBlank()) {
            throw new IllegalArgumentException("Plate number is required.");
        }

        if (!Double.isFinite(capacity) || capacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity.");
        }

        this.plateNumber = plateNumber;
        this.capacity = capacity;
    }

    public abstract String getType();

    public boolean canCarry(double weight) {
        return Double.isFinite(weight)
                && weight > 0
                && weight <= capacity;
    }

    public void assign(double weight) {
        if (!available) {
            throw new IllegalStateException("Vehicle is already busy.");
        }

        if (!canCarry(weight)) {
            throw new IllegalArgumentException(
                    "Invalid cargo weight or capacity exceeded."
            );
        }

        available = false;
    }

    public void release() {
        available = true;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public double getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return getType() + " | " + plateNumber
                + " | Capacity: " + capacity + " kg"
                + " | Available: " + available;
    }
}