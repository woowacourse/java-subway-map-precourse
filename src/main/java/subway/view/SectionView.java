package subway.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import subway.Subway;
import subway.domain.Line;
import subway.domain.Station;
import subway.util.Constants;
import subway.util.InputUtils;
import subway.util.MessageUtils;

public class SectionView {

    private boolean isRunning = true;

    private Subway subway;
    private Scanner scanner;
    private Map<String, Runnable> menuActionMap;

    public SectionView(Subway subway, Scanner scanner) {
        this.subway = subway;
        this.scanner = scanner;

        menuActionMap = Map.of(
            "1", this::insertSection,
            "2", this::deleteSection,
            Constants.BACKWARD_INPUT_CHARACTER, this::goBackward
        );
    }

    public void start() {
        isRunning = true;
        while (isRunning) {
            menuSelector();
        }
    }

    private void menuSelector() {
        MessageUtils.printMenu(Constants.MENU_GROUPS.get(Constants.SECTION_MENU_STATE));
        MessageUtils.printInputAnnouncement(Constants.ANNOUNCEMENT_FEATURE_SELECT_COMMENT);

        String input = scanner.next().toUpperCase();
        Runnable action = menuActionMap.get(input);

        if (action == null) {
            MessageUtils.printError(Constants.INVALID_STRING_OUTPUT_COMMENT);
            return;
        }
        action.run();
    }

    private void insertSection() {
        try {
            MessageUtils.printBlankLine();
            MessageUtils.printInputAnnouncement(Constants.ADD_SECTION_LINE_INPUT_COMMENT);
            Line line = getLineOrNullCheckThrow(scanner.next());
            MessageUtils.printInputAnnouncement(Constants.ADD_SECTION_STATION_INPUT_COMMENT);
            Station station = getStationOrNullCheckThrow(scanner.next());
            checkEmptySectionOrThrow(line, station);
            MessageUtils.printInputAnnouncement(Constants.ADD_SECTION_INDEX_INPUT_COMMENT);
            int refinedIndex = InputUtils.getPositiveIntOrThrow(scanner.next());
            checkValidationLengthOrThrow(line, refinedIndex);

            subway.getSectionRepository().addSection(line, station, refinedIndex);
            MessageUtils.printInfo(Constants.ADD_SECTION_OUTPUT_COMMENT);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private boolean isExistCheckStationInLine(Line line, Station station) {
        List<Station> stations = subway.getSectionRepository().getStationListInLine(line);
        for (Station instanceStation : stations) {
            if (instanceStation.equals(station)) {
                return true;
            }
        }
        return false;
    }

    private void checkEmptySectionOrThrow(Line line, Station station) {
        if (isExistCheckStationInLine(line, station)) {
            throw new RuntimeException(Constants.EXIST_STATION_OUTPUT_COMMENT);
        }
    }

    private void checkValidationLengthOrThrow(Line line, int index) {
        if (index > subway.getSectionRepository().getSize(line)) {
            throw new RuntimeException(Constants.INVALID_LENGTH_ERROR_COMMENT);
        }
    }

    private void deleteSection() {
        try {
            MessageUtils.printBlankLine();
            MessageUtils.printInputAnnouncement(Constants.DELETE_SECTION_LINE_INPUT_COMMENT);
            Line line = getLineOrNullCheckThrow(scanner.next());
            MessageUtils.printInputAnnouncement(Constants.DELETE_SECTION_STATION_INPUT_COMMENT);
            Station station = getStationOrNullCheckThrow(scanner.next());
            checkExistSectionOrThrow(line, station);

            subway.getSectionRepository().deleteSection(line, station);
            MessageUtils.printInfo(Constants.DELETE_SECTION_OUTPUT_COMMENT);
            MessageUtils.printBlankLine();
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
            MessageUtils.printBlankLine();
        }
    }

    private Line getLineOrNullCheckThrow(String lineName) {
        Line line = subway.getLineRepository().findByName(lineName);
        if (line == null) {
            throw new RuntimeException(Constants.NO_EXIST_LINE_OUTPUT_COMMENT);
        }
        MessageUtils.printBlankLine();
        return line;
    }

    private Station getStationOrNullCheckThrow(String stationName) {
        Station station = subway.getStationRepository().findByName(stationName);
        if (station == null) {
            throw new RuntimeException(Constants.NO_EXIST_STATION_OUTPUT_COMMENT);
        }
        MessageUtils.printBlankLine();
        return station;
    }

    private void checkExistSectionOrThrow(Line line, Station station) {
        if (!isExistCheckStationInLine(line, station)) {
            throw new RuntimeException(Constants.NO_EXIST_SECTION_OUTPUT_COMMENT);
        }
    }

    public void goBackward() {
        isRunning = false;
    }
}