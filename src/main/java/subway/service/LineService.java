package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.line.LineRepository;
import subway.domain.station.StationName;
import subway.exception.SubwayProgramException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineService {
    private static final String LINE_DUPLICATE_ERROR = "노선 목록에 이미 등록되어 있는 노선입니다.";
    private static final String LINE_NOT_EXIST_ERROR = "노선 목록에 등록되어 있는 노선이 아닙니다.";
    private static final String UP = "상";
    private static final String DOWN = "하";

    private final Scanner scanner;

    public LineService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addLineInLineRepository(String category) {
        try {
            LineName lineName = InputView.inputLineNameToAdd(scanner, category);
            validateLineDuplicate(lineName);
            addLine(lineName);
            OutputView.printAddMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateLineDuplicate(LineName lineName) {
        if (LineRepository.hasLine(lineName)) {
            throw new SubwayProgramException(LINE_DUPLICATE_ERROR);
        }
    }

    private void addLine(LineName lineName) {
        StationName upLastStationName = InputView.inputUpOrDownLastStationName(scanner, UP);
        StationService.validateStationExist(upLastStationName);
        StationName downLastStationName = InputView.inputUpOrDownLastStationName(scanner, DOWN);
        StationService.validateStationExist(downLastStationName);
        upLastStationName.isSame(downLastStationName);
        Line newLine = Line.of(lineName, upLastStationName, downLastStationName);
        LineRepository.addLine(newLine);
    }

    public void deleteLineInLineRepository(String category) {
        try {
            LineName lineName = InputView.inputLineNameToDelete(scanner, category);
            validateLineExist(lineName);
            LineRepository.deleteLineByName(lineName);
            OutputView.printDeleteMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateLineExist(LineName lineName) {
        if (!LineRepository.hasLine(lineName)) {
            throw new SubwayProgramException(LINE_NOT_EXIST_ERROR);
        }
    }
}
