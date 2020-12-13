package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionService implements ServiceConstant {
    private static final String STATION_EXIST_IN_LINE_ERROR = "\n[ERROR] 이미 노선에 해당 역이 등록되어 있습니다.";
    private static final String STATION_NOT_EXIST_IN_LINE_ERROR = "\n[ERROR] 노선에 해당 역이 등록되어 있지 않습니다.";

    private final Scanner scanner;

    public SectionService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addSection(String category) {
        try {
            LineName lineName = InputView.inputLineNameToAddSection(scanner);
            Line line = LineRepository.getLineByName(lineName);
            StationName stationName = InputView.inputStationNameToAddSection(scanner);
            validateStationExistInLine(line, stationName);
            int index = InputView.inputIndexToAddSection(scanner);
            Station station = Station.of(stationName);
            line.addStationToLine(station, index);
            OutputView.printAddMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateStationExistInLine(Line line, StationName stationName) {
        if (!StationRepository.hasStation(Station.of(stationName))) {
            throw new IllegalArgumentException(STATION_NOT_EXIST_ERROR);
        }
        if (line.hasStationInLine(stationName)) {
            throw new IllegalArgumentException(STATION_EXIST_IN_LINE_ERROR);
        }
    }

    public void deleteSection(String category) {
        try {
            LineName lineName = InputView.inputLineNameToDeleteSection(scanner);
            Line line = LineRepository.getLineByName(lineName);
            StationName stationName = InputView.inputStationNameToDeleteSection(scanner);
            if (!line.hasStationInLine(stationName)) {
                throw new IllegalArgumentException(STATION_NOT_EXIST_IN_LINE_ERROR);
            }
            line.deleteStationToLine(Station.of(stationName));
            OutputView.printDeleteMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
