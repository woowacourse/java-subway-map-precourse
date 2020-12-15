package subway.view;

import java.util.Map;
import java.util.Scanner;
import subway.Subway;
import subway.domain.Line;
import subway.domain.Station;
import subway.model.MenuGroup.Menu;
import subway.util.Constants;
import subway.util.DialogUtils;
import subway.util.InputUtils;
import subway.util.MessageUtils;

public class LineView extends AbstractView {

    private Map<String, Runnable> menuActionMap;

    public LineView(Subway subway, Scanner scanner) {
        super(subway, scanner);
    }

    @Override
    public void initView() {
        menuActionMap = Map.of(
            "1", this::insertLine,
            "2", this::deleteLine,
            "3", this::showLines,
            Constants.BACKWARD_INPUT_CHARACTER, this::goBackward
        );
    }

    @Override
    public Menu getMenu() {
        return Constants.MENU_GROUPS.get(Constants.LINE_MENU_STATE);
    }

    @Override
    public Map<String, Runnable> getMenuActionMap() {
        return menuActionMap;
    }

    private void insertLine() {
        try {
            String lineName = DialogUtils.ask(scanner, Constants.ADD_LINE_ASK);
            checkValidationLineNameOrThrow(lineName);
            Station startStation =
                getStationOrThrow(DialogUtils.ask(scanner, Constants.ADD_START_STATION_ASK));
            Station endStation =
                getStationOrThrow(DialogUtils.ask(scanner, Constants.ADD_END_STATION_ASK));
            checkDuplicateStartToEnd(startStation, endStation);
            Line line = new Line(lineName);
            subway.getLineRepository().addLine(line);
            subway.getSectionRepository().addNewLine(line, startStation, endStation);
            MessageUtils.printInfo(Constants.ADDED_LINE);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void deleteLine() {
        try {
            String lineName = DialogUtils.ask(scanner, Constants.DELETE_LINE_NAME_ASK);
            Line line = getLineOrThrow(lineName);

            subway.getSectionRepository().deleteLine(line);
            subway.getLineRepository().deleteLineByName(lineName);
            MessageUtils.printInfo(Constants.DELETED_LINE);
        } catch (RuntimeException e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void checkValidationLineNameOrThrow(String lineName) {
        InputUtils.checkMinLengthOrThrow(lineName);
        if (subway.getLineRepository().isExistByName(lineName)) {
            throw new RuntimeException(Constants.EXIST_LINE);
        }
    }

    private void checkDuplicateStartToEnd(Station startStation, Station endStation) {
        if (startStation.equals(endStation)) {
            throw new RuntimeException(Constants.INVALID_START_TO_END_STATION);
        }
    }

    private Line getLineOrThrow(String lineName) {
        Line line = subway.getLineRepository().findByName(lineName);
        if (line == null) {
            throw new RuntimeException(Constants.NO_EXIST_LINE);
        }
        return line;
    }

    private Station getStationOrThrow(String stationName) {
        Station station = subway.getStationRepository().findByName(stationName);
        if (station == null) {
            throw new RuntimeException(Constants.NO_EXIST_STATION);
        }
        return station;
    }

    private void showLines() {
        MessageUtils.printAnnouncement(Constants.TITLE_LINE_LIST);
        subway.getLineRepository().findAll().forEach(line ->
            MessageUtils.printInfoEntry(line.getName()));
        MessageUtils.printBlankLine();
    }
}
