package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.exception.SubwayProgramException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionService {
    private static final String STATION_DUPLICATE_IN_LINE_ERROR = "이미 노선에 해당 역이 등록되어 있습니다.";
    private static final String STATION_NOT_EXIST_IN_LINE_ERROR = "노선에 해당 역이 등록되어 있지 않습니다.";

    private final Scanner scanner;

    public SectionService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addSection(String category) {
        try {
            LineName lineName = InputView.inputLineNameToAddSection(scanner);
            Line line = LineRepository.getLineByName(lineName);
            StationName stationName = InputView.inputStationNameToAddSection(scanner);
            StationService.validateStationExist(stationName);
            validateStationDuplicateInLine(line, stationName);
            int index = InputView.inputIndexToAddSection(scanner);
            Station station = Station.of(stationName);
            line.addStationInLine(station, index);
            OutputView.printAddMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateStationDuplicateInLine(Line line, StationName stationName) {
        if (line.hasStationInLine(stationName)) {
            throw new SubwayProgramException(STATION_DUPLICATE_IN_LINE_ERROR);
        }
    }

    public void deleteSection(String category) {
        try {
            LineName lineName = InputView.inputLineNameToDeleteSection(scanner);
            Line line = LineRepository.getLineByName(lineName);
            StationName stationName = InputView.inputStationNameToDeleteSection(scanner);
            validateStationExistInLine(line, stationName);
            line.deleteStationToLine(Station.of(stationName));
            OutputView.printDeleteMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateStationExistInLine(Line line, StationName stationName) {
        if (!line.hasStationInLine(stationName)) {
            throw new SubwayProgramException(STATION_NOT_EXIST_IN_LINE_ERROR);
        }
    }
}
