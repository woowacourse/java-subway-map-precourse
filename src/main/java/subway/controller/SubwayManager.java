package subway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.domain.constants.FunctionCommand;
import subway.view.MainView;

public class SubwayManager {
    private final MainView mainView;
    private final LineController lineController;
    private final StationController stationController;
    private final RouteController routeController;

    public SubwayManager(MainView mainView,
                         LineController lineController,
                         StationController stationController,
                         RouteController routeController
    ) {
        this.mainView = mainView;
        this.lineController = lineController;
        this.stationController = stationController;
        this.routeController = routeController;
        preprocess();
    }

    public void preprocess() {
        List<String> stations = List.of(
                "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
        );
        stationController.addStations(stations);
        List<String> lines = List.of(
                "2호선", "3호선", "신분당선"
        );
        lineController.addLines(lines);
        Map<String, List<String>> route = new HashMap<>();
        route.put("2호선", List.of("교대역", "강남역", "역삼역"));
        route.put("3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역"));
        route.put("신분당선", List.of("강남역", "양재역", "양재시민의숲역"));
        routeController.addRoutes(route);
    }

    public void run() {
        while (true) {
            mainView.printMainScreen();
            FunctionCommand function = mainView.enterFunction();
            if (function.equals(FunctionCommand.STATION)) {
                stationController.run();
            }
            if (function.equals(FunctionCommand.LINE)) {
                lineController.run();
            }
            if (function.equals(FunctionCommand.ROUTE)) {
                routeController.run();
            }
            if (function.equals(FunctionCommand.PRINT)) {
                routeController.print();
            }
            if (function.equals(FunctionCommand.QUIT)) {
                break;
            }
        }
    }
}
