package subway.controller;

import java.util.List;
import java.util.Map;
import subway.service.RouteService;

public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    public void addRoutes(Map<String, List<String>> route) {
        routeService.addAll(route);
    }
}
