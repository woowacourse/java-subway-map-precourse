package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.manager.MainManager;
import subway.utils.InitLine;
import subway.utils.InitStation;
import subway.view.Input;
import java.util.Arrays;
import java.util.Scanner;

public class SubwayMap {

    public void run(Scanner scanner) {
        init(scanner);
        MainManager.run();
    }

    private void init(Scanner scanner) {
        Input.init(scanner);
        initStations();
        initLines();
    }

    private void initStations() {
        Arrays.stream(InitStation.values())
                .forEach(station -> StationRepository.addStation(new Station(station.name())));
    }

    private void initLines() {
        Arrays.stream(InitLine.values())
                .forEach(line -> LineRepository.addLine(new Line(line.getName())));
    }
}
