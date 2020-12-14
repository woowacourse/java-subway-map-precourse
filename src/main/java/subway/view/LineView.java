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

    private void checkValidationLineNameOrThrow(String lineName) {
        InputUtils.isMinLengthString(lineName);
        if (isExistLine(lineName)) {
            throw new RuntimeException(Constants.EXIST_LINE_OUTPUT_COMMENT);
        }
    }

    private void showLines() {
        MessageUtils.printAnnouncement(Constants.TITLE_WHOLE_LINE_TEXT);
        for (Object line : subway.getLineRepository().findAll()) {
            MessageUtils.printInfoEntry((String) line);
        }
        MessageUtils.printBlankLine();
    }

}
