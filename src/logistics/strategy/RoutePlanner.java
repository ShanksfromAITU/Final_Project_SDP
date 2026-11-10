package logistics.strategy;

import logistics.model.Route;
import java.util.List;
import java.util.Objects;

public class RoutePlanner {
    private RouteStrategy strategy;

    public RoutePlanner(RouteStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(
                strategy, "Strategy is required."
        );
    }

    public Route planRoute(List<Route> routes) {
        if (routes == null || routes.isEmpty()) {
            throw new IllegalArgumentException("No routes available.");
        }

        if (routes.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Route cannot be null.");
        }

        return strategy.selectRoute(routes);
    }
}