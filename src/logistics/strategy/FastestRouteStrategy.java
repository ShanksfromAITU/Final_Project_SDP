package logistics.strategy;

import logistics.model.Route;
import java.util.Comparator;
import java.util.List;

public class FastestRouteStrategy implements RouteStrategy {
    @Override
    public Route selectRoute(List<Route> routes) {
        return routes.stream()
                .min(Comparator.comparingDouble(Route::getDurationHours))
                .orElseThrow(() ->
                        new IllegalArgumentException("No routes available."));
    }
}