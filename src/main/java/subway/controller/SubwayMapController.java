package subway.controller;

import subway.domain.LineStationFactory;
import subway.domain.LineStationRepository;

public class SubwayMapController {
    private final LineStationRepository lineStation;

    public SubwayMapController() {
        lineStation = new LineStationRepository(LineStationFactory.init());
    }

    public void run() {

    }
}