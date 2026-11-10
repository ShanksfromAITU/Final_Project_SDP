package logistics.model;

public class Route {
    private final String name;
    private final double distanceKm;
    private final double durationHours;
    private final double cost;

    public Route(String name, double distanceKm,
                 double durationHours, double cost) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Route name is required.");
        }

        if (!isPositive(distanceKm) || !isPositive(durationHours)
                || !Double.isFinite(cost) || cost < 0) {
            throw new IllegalArgumentException("Invalid route values.");
        }

        this.name = name;
        this.distanceKm = distanceKm;
        this.durationHours = durationHours;
        this.cost = cost;
    }

    private static boolean isPositive(double value) {
        return Double.isFinite(value) && value > 0;
    }

    public String getName() {
        return name;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public double getDurationHours() {
        return durationHours;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name
                + " | " + distanceKm + " km"
                + " | " + durationHours + " hours"
                + " | " + cost + " KZT";
    }
}