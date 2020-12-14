package subway.view;

import subway.domain.command.LineCommand;
import subway.domain.command.MainCommand;
import subway.domain.command.StationCommand;
import subway.domain.line.Line;
import subway.domain.station.Station;

import java.util.Scanner;

public class InputView {
    private static final String SELECTION_GUIDE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String REGISTRATION_STATION_GUIDE_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String DELETION_STATION_GUIDE_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    private static final String REGISTRATION_LINE_GUIDE_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String UPWARD_END_STATION_GUIDE_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWNWARD_END_STATION_GUIDE_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String DELETION_LINE_GUIDE_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainCommand inputMainCommand() {
        printSectionGuideMessage();
        String userMessage = inputWithTrimming();
        lineFeed();
        return MainCommand.getCommand(userMessage);
    }

    public StationCommand inputStationCommand() {
        printSectionGuideMessage();
        String userMessage = inputWithTrimming();
        lineFeed();
        return StationCommand.getCommand(userMessage);
    }

    public Station inputRegistrationStation() {
        println(REGISTRATION_STATION_GUIDE_MESSAGE);
        String stationName = inputWithTrimming();
        lineFeed();
        return new Station(stationName);
    }

    public String inputDeletionStation() {
        println(DELETION_STATION_GUIDE_MESSAGE);
        String stationName = inputWithTrimming();
        lineFeed();
        return stationName;
    }

    public LineCommand inputLineCommand() {
        printSectionGuideMessage();
        String userMessage = inputWithTrimming();
        lineFeed();
        return LineCommand.getCommand(userMessage);
    }

    public Line inputRegistrationLine() {
        String lineName = inputLineName();
        String upwardEndStationName = inputUpwardEndStationName();
        String downwardEndStationName = inputDownwardEndStationName();
        return Line.createLine(lineName, upwardEndStationName, downwardEndStationName);
    }

    private String inputLineName() {
        println(REGISTRATION_LINE_GUIDE_MESSAGE);
        String lineName = inputWithTrimming();
        lineFeed();
        return lineName;
    }

    private String inputUpwardEndStationName() {
        println(UPWARD_END_STATION_GUIDE_MESSAGE);
        String upwardEndStationName = inputWithTrimming();
        lineFeed();
        return upwardEndStationName;
    }

    private String inputDownwardEndStationName() {
        println(DOWNWARD_END_STATION_GUIDE_MESSAGE);
        String downwardEndStationName = inputWithTrimming();
        lineFeed();
        return downwardEndStationName;
    }

    public String inputDeletionLine() {
        println(DELETION_LINE_GUIDE_MESSAGE);
        String lineName = inputWithTrimming();
        lineFeed();
        return lineName;
    }

    private void printSectionGuideMessage() {
        println(SELECTION_GUIDE_MESSAGE);
    }

    private String inputWithTrimming() {
        String inputValue = scanner.nextLine();
        return inputValue.trim();
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void lineFeed() {
        System.out.println();
    }
}
