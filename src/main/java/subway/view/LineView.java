package subway.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import subway.Subway;
import subway.domain.Line;
import subway.domain.Station;
import subway.util.Constants;
import subway.util.MessageUtils;

public class LineView {

    private Subway subway;
    private Scanner userInput;

    public LineView(Subway subway, Scanner scanner) {
        this.subway = subway;
        this.userInput = scanner;
    }

    public String menuSelector(Scanner userInput) {
        String input = userInput.next();
        MessageUtils.printBlankLine();
        String thisMenuState = Constants.LINE_MENU_STATE;
        if (input.equals("1")) {
            this.insertLine(userInput);
        }
        if (input.equals("2")) {
            this.deleteLine(userInput);
        }
        if (input.equals("3")) {
            this.showLines();
        }
        if (input.equalsIgnoreCase(Constants.BACKWARD_INPUT_CHARACTER)) {
            thisMenuState = Constants.MAIN_MENU_STATE;
        }
        if (!(input.equals("1") || input.equals("2") || input.equals("3")
            || input.equalsIgnoreCase(Constants.BACKWARD_INPUT_CHARACTER))) {
            MessageUtils.printError(Constants.INVALID_STRING_OUTPUT_COMMENT);
        }
        return thisMenuState;
    }

    private boolean insertLine(Scanner userInput) {
        MessageUtils.printInputAnnouncement(Constants.ADD_LINE_NAME_INPUT_COMMENT);
        String lineName = userInput.next();
        MessageUtils.printBlankLine();
        if (isExistLineName(lineName)) {
            MessageUtils.printError(Constants.EXIST_LINE_OUTPUT_COMMENT);
            return false;
        }
        List<Station> p2pStations = p2pStation(userInput);
        if (p2pStations != null) {
            subway.getLineRepository().addLine(new Line(lineName));
            Line newLine = subway.getLineRepository().findByName(lineName);
            subway.getSectionRepository().addLine(newLine, p2pStations.get(0), p2pStations.get(1));
            MessageUtils.printInfo(Constants.ADD_LINE_OUTPUT_COMMENT);
            return true;
        }
        return false;
    }

    private List<Station> p2pStation(Scanner userInput) {
        MessageUtils.printInputAnnouncement(Constants.ADD_LINE_START_STATION_NAME_INPUT_COMMENT);
        String startStationInLineName = userInput.next();
        MessageUtils.printBlankLine();
        MessageUtils.printInputAnnouncement(Constants.ADD_LINE_END_STATION_NAME_INPUT_COMMENT);
        String endStationInLineName = userInput.next();
        MessageUtils.printBlankLine();
        if (!isExistStationName(startStationInLineName) || !isExistStationName(
            endStationInLineName)) {
            MessageUtils.printError(Constants.NO_EXIST_STATION_OUTPUT_COMMENT);
            return null;
        }
        if (isExistStationName(startStationInLineName) && isExistStationName(
            endStationInLineName)) {
            List<Station> stationList = new ArrayList<>();
            stationList.add(subway.getStationRepository().findByName(startStationInLineName));
            stationList.add(subway.getStationRepository().findByName(endStationInLineName));
            return stationList;
        }
        return null;
    }

    private boolean isExistStationName(String stationName) {
        if (subway.getStationRepository().findByName(stationName) == null) {
            return false;
        }
        return true;
    }

    private boolean isExistLineName(String lineName) {
        if (subway.getLineRepository().findByName(lineName) == null) {
            return false;
        }
        return true;
    }

    private boolean deleteLine(Scanner userInput) {
        MessageUtils.printInputAnnouncement(Constants.DELETE_LINE_END_STATION_NAME_INPUT_COMMENT);
        String targetLineName = userInput.next();
        MessageUtils.printBlankLine();
        if (!isExistLineName(targetLineName)) {
            MessageUtils.printError(Constants.NO_EXIST_LINE_OUTPUT_COMMENT);
            return false;
        }
        subway.getSectionRepository()
            .deleteLine(subway.getLineRepository().findByName(targetLineName));
        subway.getLineRepository().deleteLineByName(targetLineName);
        MessageUtils.printInfo(Constants.DELETE_LINE_OUTPUT_COMMENT);
        return true;
    }

    private void showLines() {
        MessageUtils.printInputAnnouncement(Constants.TITLE_WHOLE_LINE_TEXT);
        for (Object line : subway.getLineRepository().findAll()) {
            MessageUtils.printInfo((String) line);
        }
    }
}
