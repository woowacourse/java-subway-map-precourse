package subway.maintain;

import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class MapMaintain {

    public MapMaintain(Scanner scanner) {
        map();
        new Controller(scanner);
    }

    private void map() {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            OutputView.status(line.getName());
            stationMap(line);
        }
    }

    private void stationMap(Line line) {
        List<Station> stations = line.getStations();
        for (Station station : stations) {
            OutputView.status(station.getName());
        }
        OutputView.space();
    }
}
