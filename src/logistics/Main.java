package logistics;

import logistics.builder.DeliveryOrderBuilder;
import logistics.model.DeliveryOrder;

public class Main {
    public static void main(String[] args) {
        DeliveryOrder order = new DeliveryOrderBuilder()
                .sender("Amir")
                .receiver("Rakhat")
                .origin("Astana")
                .destination("Almaty")
                .weight(500)
                .build();

        System.out.println(order);
    }
}