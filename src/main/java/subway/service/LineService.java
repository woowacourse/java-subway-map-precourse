package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.line.LineRepository;
import subway.domain.station.StationName;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineService {

    private static final String UP = "상";
    private static final String DOWN = "하";
    private final Scanner scanner;

    public LineService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addLineInLineRepository(String category) {
        try {
            LineName lineName = InputView.inputLineNameAdd(scanner, category);
            LineRepository.validateDuplicate(lineName);
            StationName upLastStationName = InputView.inputUpOrDownLastStationName(scanner, UP);
            StationRepository.validateNameExist(upLastStationName);
            StationName downLastStationName = InputView.inputUpOrDownLastStationName(scanner, DOWN);
            StationRepository.validateNameExist(downLastStationName);
            upLastStationName.compareName(downLastStationName);
            Line newLine = Line.createLine(lineName, upLastStationName, downLastStationName);
            LineRepository.addLine(newLine);
            OutputView.printAddMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteLineInLineRepository(String category) {
        try {
            LineName lineName = InputView.inputLineNameDelete(scanner, category);
            LineRepository.deleteLineByName(lineName);
            OutputView.printDeleteMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
