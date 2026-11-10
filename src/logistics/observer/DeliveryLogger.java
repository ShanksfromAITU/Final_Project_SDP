package logistics.observer;

import java.util.ArrayList;
import java.util.List;

public class DeliveryLogger implements DeliveryObserver {
    private final List<String> history = new ArrayList<>();

    @Override
    public void update(String message) {
        history.add(message);
        System.out.println("[Log] " + message);
    }

    public List<String> getHistory() {
        return List.copyOf(history);
    }
}