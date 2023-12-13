package subway.controller;

import java.util.List;
import java.util.Map;
import subway.domain.constants.LineCommand;
import subway.domain.constants.RouteCommand;
import subway.service.RouteService;
import subway.view.RouteView;

public class RouteController {
    private final RouteService routeService;
    private final RouteView routeView;

    public RouteController(RouteService routeService, RouteView routeView) {
        this.routeService = routeService;
        this.routeView = routeView;
    }

    public void addRoutes(Map<String, List<String>> route) {
        routeService.addAll(route);
    }

    public void run() {
        routeView.printFunctions();
        RouteCommand function = routeView.enterFunction();
        if (function.equals(LineCommand.ADD)) {
            addRoute();
        }
        if (function.equals(LineCommand.DELETE)) {
            deleteRoute();
        }
    }

    private void addRoute() {
        String line = routeView.enterLineNameToAdd();
        String station = routeView.enterStationNameToAdd();
        int index = routeView.enterIndexToAdd();
        routeService.addStation(line, station, index);
        routeView.printAddResult();
    }

    /**
     * 구간을 삭제하는 함수
     */
    private void deleteRoute() {
        String line = routeView.enterLineNameToDelete();
        String station = routeView.enterStationNameToDelete();
        routeService.deleteStation(line, station);
        routeView.printDeleteResult();
    }
}
