package subway.view;

import java.util.Map;
import java.util.Scanner;
import subway.Subway;
import subway.domain.Line;
import subway.domain.Station;
import subway.util.Constants;
import subway.util.DialogUtils;
import subway.util.InputUtils;
import subway.util.MessageUtils;

public class LineView {

    private boolean isRunning = true;

    private Subway subway;
    private Scanner scanner;
    private Map<String, Runnable> menuActionMap;

    public LineView(Subway subway, Scanner scanner) {
        this.subway = subway;
        this.scanner = scanner;

        menuActionMap = Map.of(
            "1", this::insertLine,
            "2", this::deleteLine,
            "3", this::showLines,
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
        MessageUtils.printMenu(Constants.MENU_GROUPS.get(Constants.LINE_MENU_STATE));
        String input = scanner.next().toUpperCase();
        MessageUtils.printBlankLine();

        Runnable action = menuActionMap.get(input);

        if (action == null) {
            MessageUtils.printError(Constants.INVALID_STRING_OUTPUT_COMMENT);
            return;
        }
        action.run();
    }

    private void insertLine() {
        try {
            String lineName = DialogUtils.ask(scanner, Constants.ADD_LINE_NAME_INPUT_COMMENT);
            checkValidationLineNameOrThrow(lineName);
            Station startStation = getStationOrThrow(
                DialogUtils.ask(scanner, Constants.ADD_START_STATION_NAME_INPUT_COMMENT));
            Station endStation = getStationOrThrow(
                DialogUtils.ask(scanner, Constants.ADD_END_STATION_NAME_INPUT_COMMENT));

            Line line = new Line(lineName);
            subway.getLineRepository().addLine(line);
            subway.getSectionRepository().addNewLine(line, startStation, endStation);
            MessageUtils.printInfo(Constants.ADD_LINE_OUTPUT_COMMENT);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void deleteLine() {
        try {
            String lineName = DialogUtils.ask(scanner, Constants.DELETE_LINE_NAME_INPUT_COMMENT);
            Line line = getLineOrThrow(lineName);

            subway.getSectionRepository().deleteLine(line);
            subway.getLineRepository().deleteLineByName(lineName);
            MessageUtils.printInfo(Constants.DELETE_LINE_OUTPUT_COMMENT);
        } catch (RuntimeException e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    public void goBackward() {
        isRunning = false;
    }

    private void checkValidationLineNameOrThrow(String lineName) {
        InputUtils.isMinLengthString(lineName);
        if (isExistLine(lineName)) {
            throw new RuntimeException(Constants.EXIST_LINE_OUTPUT_COMMENT);
        }
    }

    private Line getLineOrThrow(String lineName) {
        if (!isExistLine(lineName)) {
            throw new RuntimeException(Constants.NO_EXIST_LINE_OUTPUT_COMMENT);
        }
        return subway.getLineRepository().findByName(lineName);
    }

    private Station getStationOrThrow(String stationName) {
        if (!isExistStation(stationName)) {
            throw new RuntimeException(Constants.NO_EXIST_STATION_OUTPUT_COMMENT);
        }
        return subway.getStationRepository().findByName(stationName);
    }

    private boolean isExistLine(String lineName) {
        if (subway.getLineRepository().findByName(lineName) == null) {
            return false;
        }
        return true;
    }

    private boolean isExistStation(String stationName) {
        if (subway.getStationRepository().findByName(stationName) == null) {
            return false;
        }
        return true;
    }

    private void showLines() {
        MessageUtils.printAnnouncement(Constants.TITLE_WHOLE_LINE_TEXT);
        for (Object line : subway.getLineRepository().findAll()) {
            MessageUtils.printInfoEntry((String) line);
        }
        MessageUtils.printBlankLine();
    }

}
