package logistics.strategy;

import logistics.model.Route;
import java.util.List;

public interface RouteStrategy {
    Route selectRoute(List<Route> routes);
}