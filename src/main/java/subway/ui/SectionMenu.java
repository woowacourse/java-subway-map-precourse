package subway.ui;

import java.util.Optional;
import java.util.Scanner;
import subway.UtilityFunctions;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.message.ErrorMessage;
import subway.message.InfoMessage;

public class SectionMenu {

    private static final String ADD_SECTION_LINE_MESSAGE = "노선을 입력하세요.";
    private static final String ADD_SECTION_STATION_MESSAGE = "역이름을 입력하세요.";
    private static final String ADD_SECTION_INDEX_MESSAGE = "순서를 입력하세요.";
    private static final String DELETE_SECTION_LINE_MESSAGE = "삭제할 구간의 노선을 입력하세요.";
    private static final String DELETE_SECTION_STATION_MESSAGE = "삭제할 구간의 역을 입력하세요.";
    private static final String VIEW_SECTION_MESSAGE = "지하철 노선도";
    private static final String VIE_SECTION_DIVIDER_MESSAGE = "---";

    private SectionMenu() {
    }

    private static int validateInputIsInteger(final String lineInput) {
        final int integer;
        try {
            integer = Integer.parseInt(lineInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return integer;
    }

    public static void addSection(final Scanner scanner) throws IllegalArgumentException {
        String lineName, stationName, indexString;
        int index;
        while (true) {
            try {
                ConsoleOutput.printGeneralMessage(ADD_SECTION_LINE_MESSAGE);
                lineName = ConsoleInput.scanLine(scanner);
                ConsoleOutput.printGeneralMessage(ADD_SECTION_STATION_MESSAGE);
                stationName = ConsoleInput.scanLine(scanner);
                ConsoleOutput.printGeneralMessage(ADD_SECTION_INDEX_MESSAGE);
                indexString = ConsoleInput.scanLine(scanner);
                index = validateInputIsInteger(indexString);
                break;
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
        final Line line = UtilityFunctions.getLineByNameFromRepository(lineName);
        final Station station = UtilityFunctions.getStationByNameFromRepository(stationName);
        line.addStation(index - 1, station);
        System.out.println();
        ConsoleOutput.printInfoMessage(InfoMessage.SECTION_ADDED.toString());
    }

    public static void deleteSection(final Scanner scanner)
        throws IllegalArgumentException {
        String lineName, stationName;
        while (true) {
            try {
                ConsoleOutput.printGeneralMessage(DELETE_SECTION_LINE_MESSAGE);
                lineName = ConsoleInput.scanLine(scanner);
                ConsoleOutput.printGeneralMessage(DELETE_SECTION_STATION_MESSAGE);
                stationName = ConsoleInput.scanLine(scanner);
                break;
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
        final Line line = UtilityFunctions.getLineByNameFromRepository(lineName);
        final Station station = UtilityFunctions.getStationByNameFromRepository(stationName);
        line.removeStation(station);
        System.out.println();
        ConsoleOutput.printInfoMessage(InfoMessage.SECTION_REMOVED.toString());
    }

    public static void viewSection() throws IllegalArgumentException {
        if (LineRepository.lines().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.LINE_REPOSITORY_EMPTY.toString());
        }
        ConsoleOutput.printGeneralMessage(VIEW_SECTION_MESSAGE);
        for (Line line : LineRepository.lines()) {
            ConsoleOutput.printInfoMessage(line.getName());
            ConsoleOutput.printInfoMessage(VIE_SECTION_DIVIDER_MESSAGE);
            for (Station station : line.getStations()) {
                ConsoleOutput.printInfoMessage(station.getName());
            }
            System.out.println();
        }
    }

    public static void run(final Scanner scanner) throws IllegalArgumentException {
        while (true) {
            ConsoleOutput.printSectionMenu();
            String lineInput;
            try {
                lineInput = ConsoleInput.scanLine(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
                continue;
            }
            Optional<SectionMenuEnum> optional = SectionMenuEnum.of(lineInput);
            if (optional.isEmpty()) {
                ConsoleOutput.printErrorMessage(ErrorMessage.MENU_INVALID_SELECTION.toString());
                continue;
            }
            SectionMenuEnum sectionMenuEnum = optional.get();
            if (sectionMenuEnum.equals(SectionMenuEnum.GO_BACK)) {
                break;
            }
            sectionMenuEnum.action(scanner);
        }
    }
}
