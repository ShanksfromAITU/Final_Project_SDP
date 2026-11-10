package logistics;

import logistics.builder.DeliveryOrderBuilder;
import logistics.decorator.*;
import logistics.model.DeliveryOrder;
import logistics.model.Route;

public class OrderDemo {
    public static void main(String[] args) {
        DeliveryOrder order = new DeliveryOrderBuilder()
                .sender("Amir")
                .receiver("Dias")
                .origin("Astana")
                .destination("Almaty")
                .weight(500)
                .build();

        System.out.println("=== ORDER ===");
        System.out.println(order);

        Route route = new Route(
                "Economy road", 1300, 20, 30000
        );

        DeliveryService service = new BasicDelivery(order, route);

        System.out.println("\n=== BASIC DELIVERY ===");
        printService(service);

        service = new InsuranceDecorator(service);

        System.out.println("\n=== WITH INSURANCE ===");
        printService(service);

        service = new FragileCargoDecorator(service);

        System.out.println("\n=== WITH BOTH SERVICES ===");
        printService(service);

        System.out.println("\n=== INVALID ORDER ===");

        try {
            new DeliveryOrderBuilder()
                    .sender("Amir")
                    .receiver("Dias")
                    .origin("Astana")
                    .destination("Almaty")
                    .weight(-10)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }

    private static void printService(DeliveryService service) {
        System.out.println(service.getDescription());
        System.out.println("Total: " + service.getCost() + " KZT");
    }
}
