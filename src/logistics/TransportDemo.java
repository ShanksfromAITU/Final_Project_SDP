package logistics;

import logistics.factory.*;
import logistics.model.*;
import logistics.strategy.*;

import java.util.List;

public class TransportDemo {
    public static void main(String[] args) {
        // Factory Method
        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        VehicleFactory vanFactory = new VanFactory();
        VehicleFactory truckFactory = new TruckFactory();

        Vehicle motorcycle = motorcycleFactory.createVehicle("001AAA");
        Vehicle van = vanFactory.createVehicle("002BBB");
        Vehicle truck = truckFactory.createVehicle("003CCC");

        System.out.println("=== FLEET ===");
        System.out.println(motorcycle);
        System.out.println(van);
        System.out.println(truck);

        // Cargo assignment
        System.out.println("\n=== ASSIGNMENT ===");

        double cargoWeight = 500;

        System.out.println(
                "Motorcycle can carry 500 kg: "
                        + motorcycle.canCarry(cargoWeight)
        );

        van.assign(cargoWeight);
        System.out.println("Assigned: " + van);

        // A busy vehicle cannot receive another order.
        try {
            van.assign(100);
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        van.release();
        System.out.println("Released: " + van);

        // Illustrative routes for the same origin and destination.
        List<Route> routes = List.of(
                new Route("Highway", 1250, 14, 45000),
                new Route("Direct road", 1100, 18, 38000),
                new Route("Economy road", 1300, 20, 30000)
        );

        // Strategy
        System.out.println("\n=== ROUTES ===");

        RoutePlanner planner = new RoutePlanner(
                new FastestRouteStrategy()
        );

        System.out.println("Fastest: " + planner.planRoute(routes));

        planner.setStrategy(new ShortestRouteStrategy());
        System.out.println("Shortest: " + planner.planRoute(routes));

        planner.setStrategy(new CheapestRouteStrategy());
        System.out.println("Cheapest: " + planner.planRoute(routes));
    }
}