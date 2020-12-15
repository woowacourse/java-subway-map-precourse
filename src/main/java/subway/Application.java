package subway;

import subway.controller.ControllerContainer;
import subway.controller.main.MainMenuController;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.repository.line.LineRepository;
import subway.repository.line.LineRepositoryImpl;
import subway.repository.station.StationRepository;
import subway.repository.station.StationRepositoryImpl;
import subway.service.*;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        LineRepository lineRepository = ControllerContainer.getLineRepository();
        StationRepository stationRepository = ControllerContainer.getStationRepository();

        DummyData.init();

        new MainMenuController(stationRepository, lineRepository).run();
    }
}
