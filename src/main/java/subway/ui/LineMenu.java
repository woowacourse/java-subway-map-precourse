package subway.ui;

import static subway.UtilityFunctions.generateStationsByName;
import static subway.message.ErrorMessage.LINE_REPOSITORY_EMPTY;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.message.ErrorMessage;
import subway.message.InfoMessage;

public class LineMenu {

    private static final String ADD_LINE_MESSAGE = "등록할 노선 이름을 입력하세요.";
    private static final String ADD_LINE_START_STATION_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ADD_LINE_END_STATION_MESSAGE = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String DELETE_LINE_MESSAGE = "삭제할 노선 이름을 입력하세요.";
    private static final String VIEW_LINE_MESSAGE = "노선 목록";

    private LineMenu() {
    }

    public static void addLine(final Scanner scanner) throws IllegalArgumentException {
        String lineName, startStationName, endStationName;
        while (true) {
            try {
                ConsoleOutput.printGeneralMessage(ADD_LINE_MESSAGE);
                lineName = ConsoleInput.scanLine(scanner);
                ConsoleOutput.printGeneralMessage(ADD_LINE_START_STATION_MESSAGE);
                startStationName = ConsoleInput.scanLine(scanner);
                ConsoleOutput.printGeneralMessage(ADD_LINE_END_STATION_MESSAGE);
                endStationName = ConsoleInput.scanLine(scanner);
                break;
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
        final List<Station> stations = generateStationsByName(startStationName, endStationName);
        final Line line = new Line(lineName, stations);
        try {
            LineRepository.addLine(line);
        } catch (IllegalArgumentException e) {
            ConsoleOutput.printErrorMessage(e.getMessage());
            line.removeAllStations();
        }
        ConsoleOutput.printInfoMessage(InfoMessage.LINE_ADDED.toString());
    }

    public static void deleteLine(final Scanner scanner) throws IllegalArgumentException {
        String name;
        while (true) {
            ConsoleOutput.printGeneralMessage(DELETE_LINE_MESSAGE);
            try {
                name = ConsoleInput.scanLine(scanner);
                break;
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
        LineRepository.deleteLineByName(name);
        ConsoleOutput.printInfoMessage(InfoMessage.LINE_REMOVED.toString());
    }

    public static void viewLine() {
        if (LineRepository.lines().isEmpty()) {
            throw new IllegalArgumentException(LINE_REPOSITORY_EMPTY.toString());
        }
        ConsoleOutput.printGeneralMessage(VIEW_LINE_MESSAGE);
        for (Line line : LineRepository.lines()) {
            ConsoleOutput.printInfoMessage(line.getName());
        }
    }

    public static void run(final Scanner scanner) {
        while (true) {
            ConsoleOutput.printLineMenu();
            String lineInput;
            try {
                lineInput = ConsoleInput.scanLine(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
                continue;
            }
            Optional<LineMenuEnum> optional = LineMenuEnum.of(lineInput);
            if (optional.isEmpty()) {
                ConsoleOutput.printErrorMessage(ErrorMessage.MENU_INVALID_SELECTION.toString());
                continue;
            }
            LineMenuEnum lineMenuEnum = optional.get();
            if (lineMenuEnum.equals(LineMenuEnum.GO_BACK)) {
                break;
            }
            lineMenuEnum.action(scanner);
        }
    }
}
