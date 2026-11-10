package logistics;

import logistics.builder.DeliveryOrderBuilder;
import logistics.decorator.*;
import logistics.factory.*;
import logistics.model.*;
import logistics.observer.*;
import logistics.state.Delivery;
import logistics.strategy.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Builder: create an order.
        DeliveryOrder order = new DeliveryOrderBuilder()
                .sender("Amir")
                .receiver("Dias")
                .origin("Astana")
                .destination("Almaty")
                .weight(500)
                .build();

        System.out.println("=== ORDER ===");
        System.out.println(order);

        // 2. Factory Method: create the fleet.
        List<Vehicle> fleet = List.of(
                new MotorcycleFactory().createVehicle("001AAA"),
                new VanFactory().createVehicle("002BBB"),
                new TruckFactory().createVehicle("003CCC")
        );

        System.out.println("\n=== FLEET ===");
        fleet.forEach(System.out::println);

        Vehicle selectedVehicle = fleet.stream()
                .filter(Vehicle::isAvailable)
                .filter(vehicle -> vehicle.canCarry(order.getWeight()))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException("No suitable vehicle."));

        System.out.println("Selected: " + selectedVehicle.getType());

        // 3. Strategy: compare routes for Astana -> Almaty.
        List<Route> routes = List.of(
                new Route("Highway", 1250, 14, 45000),
                new Route("Direct road", 1100, 18, 38000),
                new Route("Economy road", 1300, 20, 30000)
        );

        RoutePlanner planner =
                new RoutePlanner(new FastestRouteStrategy());

        System.out.println("\n=== ROUTES ===");
        System.out.println("Fastest: " + planner.planRoute(routes));

        planner.setStrategy(new ShortestRouteStrategy());
        System.out.println("Shortest: " + planner.planRoute(routes));

        planner.setStrategy(new CheapestRouteStrategy());
        Route selectedRoute = planner.planRoute(routes);
        System.out.println("Selected cheapest: " + selectedRoute);

        // 4. Decorator: add services.
        DeliveryService service = new BasicDelivery(order, selectedRoute);
        service = new InsuranceDecorator(service);
        service = new FragileCargoDecorator(service);

        System.out.println("\n=== PRICE ===");
        System.out.println(service.getDescription());
        System.out.println("Total: " + service.getCost() + " KZT");

        // 5. Observer: subscribe to status changes.
        Delivery delivery = new Delivery(order);
        DeliveryLogger logger = new DeliveryLogger();

        delivery.addObserver(new CustomerNotifier(order.getReceiver()));
        delivery.addObserver(logger);

        // 6. State: perform delivery.
        System.out.println("\n=== DELIVERY ===");
        System.out.println("Initial status: " + delivery.getStatus());

        delivery.assignVehicle(selectedVehicle);
        System.out.println(
                "Vehicle available: " + selectedVehicle.isAvailable()
        );

        delivery.dispatch();
        delivery.complete();

        System.out.println("\n=== RESULT ===");
        System.out.println("Final status: " + delivery.getStatus());
        System.out.println(
                "Vehicle available: " + selectedVehicle.isAvailable()
        );
        System.out.println("Total price: " + service.getCost() + " KZT");

        System.out.println("\n=== HISTORY ===");
        logger.getHistory().forEach(System.out::println);
    }
}