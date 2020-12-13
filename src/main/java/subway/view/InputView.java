package subway.view;

import subway.domain.command.MainCommand;
import subway.domain.command.StationCommand;
import subway.domain.station.Station;

import java.util.Scanner;

public class InputView {
    private static final String SELECTION_GUIDE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String REGISTRATION_STATION_GUIDE_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String DELETION_STATION_GUIDE_MESSAGE = "## 삭제할 역 이름을 입력하세요.";

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
