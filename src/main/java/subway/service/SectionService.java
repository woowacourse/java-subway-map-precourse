package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionService {

    private final Scanner scanner;
    public SectionService(Scanner scanner) {
        this.scanner = scanner;
    }
    public void addSection(String category) {
        try {
            LineName lineName = InputView.inputLineNameToAddSection(scanner);
            Line line = LineRepository.getLineByName(lineName);
            StationName stationName = InputView.inputStationNameToAddSection(scanner);
            Station station = Station.of(stationName);
            line.validateDuplicateStationToLine(station);
            int index = InputView.inputIndexToAddSection(scanner);
            line.addStationToLine(station, index);
            OutputView.printAddMessage(category);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteSection(String category) {
        try {
            LineName lineName = InputView.inputLineNameToDeleteSection(scanner);
            Line line = LineRepository.getLineByName(lineName);
            StationName stationName = InputView.inputStationNameToDeleteSection(scanner);
            if (line.hasStationToLine(stationName)) {
                line.deleteStationToLine(Station.of(stationName));
                OutputView.printDeleteMessage(category);
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
