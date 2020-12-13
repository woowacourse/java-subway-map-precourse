package subway.view;

import java.util.Scanner;
import java.util.Set;
import subway.Subway;
import subway.domain.Station;
import subway.util.Constants;
import subway.util.InputUtils;
import subway.util.MessageUtils;

public class StationView {


    private Subway subway;
    private Scanner userInput;

    public StationView(Subway subway, Scanner scanner) {
        this.subway = subway;
        this.userInput = scanner;
    }

    public String menuSelector(Scanner userInput) {
        String input = userInput.next();
        MessageUtils.printBlankLine();
        String thisMenuState = Constants.STATION_MENU_STATE;
        if (input.equals("1")) {
            this.insertStation(userInput);
        }
        if (input.equals("2")) {
            this.deleteStation(userInput);
        }
        if (input.equals("3")) {
            this.showStations();
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

    private boolean insertStation(Scanner userInput) {
        MessageUtils.printInputAnnouncement(Constants.ADD_STATION_INPUT_COMMENT);
        String stationName = userInput.next();
        MessageUtils.printBlankLine();
        if (!InputUtils.isMinLengthString(stationName)) {
            MessageUtils.printError(Constants.INVALID_MIN_LENGTH_ERROR_COMMENT);
            return false;
        }
        if (isExistStationName(stationName)) {
            MessageUtils.printError(Constants.EXIST_STATION_OUTPUT_COMMENT);
            return false;
        }
        Station newStation = new Station(stationName);
        subway.getStationRepository().addStation(newStation);
        MessageUtils.printInfo(Constants.ADD_STATION_OUTPUT_COMMENT);
        return true;
    }

    private boolean isExistStationName(String stationName) {
        if (subway.getStationRepository().findByName(stationName) == null) {
            return false;
        }
        return true;
    }

    private void deleteStation(Scanner userInput) {
        MessageUtils.printInputAnnouncement(Constants.DELETE_STATION_INPUT_COMMENT);
        String targetStationName = userInput.next();
        MessageUtils.printBlankLine();
        Set<String> existStationInSection = subway.getSectionRepository().findIncludedStationSet();
        if (!existStationInSection.contains(targetStationName)) {
            deleteByName(targetStationName);
        }
        if (existStationInSection.contains(targetStationName)) {
            MessageUtils.printError(Constants.EXIST_STATION_IN_SECTION_OUTPUT_COMMENT);
        }
    }

    private void deleteByName(String targetStationName) {
        if (subway.getStationRepository().findByName(targetStationName) == null) {
            MessageUtils.printError(Constants.NO_EXIST_STATION_OUTPUT_COMMENT);
        }
        if (subway.getStationRepository().findByName(targetStationName) != null) {
            subway.getStationRepository().deleteStationByName(targetStationName);
            MessageUtils.printInfo(Constants.DELETE_STATION_OUTPUT_COMMENT);
        }
    }

    private void showStations() {
        MessageUtils.printInputAnnouncement(Constants.TITLE_WHOLE_STATION_TEXT);
        for (Object station : subway.getStationRepository().findAll()) {
            MessageUtils.printInfo((String) station);
        }
    }
}
