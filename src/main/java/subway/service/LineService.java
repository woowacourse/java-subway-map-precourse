package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.line.LineRepository;
import subway.domain.station.StationName;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineService implements ServiceConstant {
    private static final String UP = "상";
    private static final String DOWN = "하";
    private final Scanner scanner;

    public LineService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addLineInLineRepository(String category) {
        try {
            LineName lineName = InputView.inputLineNameAdd(scanner, category);
            if (LineRepository.hasLine(lineName)) {
                throw new IllegalArgumentException(LINE_EXIST_ERROR);
            }
            addLine(lineName, category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addLine(LineName lineName, String category) {
        StationName upLastStationName = InputView.inputUpOrDownLastStationName(scanner, UP);
        validateExistStation(upLastStationName);
        StationName downLastStationName = InputView.inputUpOrDownLastStationName(scanner, DOWN);
        validateExistStation(downLastStationName);
        upLastStationName.compareName(downLastStationName);
        Line newLine = Line.createLine(lineName, upLastStationName, downLastStationName);
        LineRepository.addLine(newLine);
        OutputView.printAddMessage(category);
    }

    private void validateExistStation(StationName stationName) {
        if (!StationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException(STATION_NOT_EXIST_ERROR);
        }
    }

    public void deleteLineInLineRepository(String category) {
        try {
            LineName lineName = InputView.inputLineNameDelete(scanner, category);
            if (!LineRepository.hasLine(lineName)) {
                throw new IllegalArgumentException(LINE_NOT_EXIST_ERROR);
            }
            LineRepository.deleteLineByName(lineName);
            OutputView.printDeleteMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
