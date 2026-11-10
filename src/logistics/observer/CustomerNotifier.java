package logistics.observer;

public class CustomerNotifier implements DeliveryObserver {
    private final String customerName;

    public CustomerNotifier(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(String message) {
        System.out.println(
                "[Customer: " + customerName + "] " + message
        );
    }
}