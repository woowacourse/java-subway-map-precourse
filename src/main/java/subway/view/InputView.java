package subway.view;

import subway.domain.command.LineCommand;
import subway.domain.command.MainCommand;
import subway.domain.command.SectionCommand;
import subway.domain.command.StationCommand;
import subway.dto.LineDto;
import subway.dto.SectionDeletionDto;
import subway.dto.SectionRegistrationDto;
import subway.dto.StationDto;

import java.util.Scanner;

public class InputView {
    private static final String SELECTION_GUIDE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String REGISTRATION_STATION_GUIDE_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String DELETION_STATION_GUIDE_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    private static final String REGISTRATION_LINE_GUIDE_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String UPWARD_END_STATION_GUIDE_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWNWARD_END_STATION_GUIDE_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String DELETION_LINE_GUIDE_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private static final String LINE_INPUT_GUIDE_MESSAGE = "## 노선을 입력하세요.";
    private static final String STATION_INPUT_GUIDE_MESSAGE = "## 역이름을 입력하세요.";
    private static final String SEQUENCE_INPUT_GUIDE_MESSAGE = "## 순서를 입력하세요.";
    private static final String DELETION_SECTION_LINE_GUIDE_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String DELETION_SECTION_STATION_GUIDE_MESSAGE = "## 삭제할 구간의 역을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainCommand inputMainCommand() {
        printSelectionGuideMessage();
        String userMessage = inputWithTrimming();
        lineFeed();
        return MainCommand.getCommand(userMessage);
    }

    public StationCommand inputStationCommand() {
        printSelectionGuideMessage();
        String userMessage = inputWithTrimming();
        lineFeed();
        return StationCommand.getCommand(userMessage);
    }

    public StationDto inputRegistrationStation() {
        println(REGISTRATION_STATION_GUIDE_MESSAGE);
        String stationName = inputWithTrimming();
        lineFeed();
        return new StationDto(stationName);
    }

    public String inputDeletionStation() {
        println(DELETION_STATION_GUIDE_MESSAGE);
        String stationName = inputWithTrimming();
        lineFeed();
        return stationName;
    }

    public LineCommand inputLineCommand() {
        printSelectionGuideMessage();
        String userMessage = inputWithTrimming();
        lineFeed();
        return LineCommand.getCommand(userMessage);
    }

    public LineDto inputRegistrationLine() {
        String lineName = inputRegistrationLineName();
        String upwardEndStationName = inputUpwardEndStationName();
        String downwardEndStationName = inputDownwardEndStationName();
        return new LineDto(lineName, upwardEndStationName, downwardEndStationName);
    }

    private String inputRegistrationLineName() {
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

    public SectionCommand inputSectionCommand() {
        printSelectionGuideMessage();
        String userMessage = inputWithTrimming();
        lineFeed();
        return SectionCommand.getCommand(userMessage);
    }

    public SectionRegistrationDto inputRegistrationSection() {
        String lineName = inputLineName();
        String stationName = inputStationName();
        String sequence = inputSequence();
        return new SectionRegistrationDto(lineName, stationName, sequence);
    }

    private String inputLineName() {
        println(LINE_INPUT_GUIDE_MESSAGE);
        String lineName = inputWithTrimming();
        lineFeed();
        return lineName;
    }

    private String inputStationName() {
        println(STATION_INPUT_GUIDE_MESSAGE);
        String stationName = inputWithTrimming();
        lineFeed();
        return stationName;
    }

    private String inputSequence() {
        println(SEQUENCE_INPUT_GUIDE_MESSAGE);
        String sequence = inputWithTrimming();
        lineFeed();
        return sequence;
    }

    public SectionDeletionDto inputDeletionSection() {
        String lineName = inputDeletionSectionLine();
        String stationName = inputDeletionSectionLine();
        return new SectionDeletionDto(lineName, stationName);
    }

    private String inputDeletionSectionLine() {
        println(DELETION_SECTION_LINE_GUIDE_MESSAGE);
        String lineName = inputWithTrimming();
        lineFeed();
        return lineName;
    }

    private String inputDeletionSectionStation() {
        println(DELETION_SECTION_STATION_GUIDE_MESSAGE);
        String stationName = inputWithTrimming();
        lineFeed();
        return stationName;
    }

    private void printSelectionGuideMessage() {
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
