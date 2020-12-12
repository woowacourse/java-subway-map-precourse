package subway.view;

import java.util.Scanner;
import java.util.Set;
import subway.Subway;
import subway.domain.Station;
import subway.util.Constants;
import subway.util.InputUtils;
import subway.util.MessageUtils;

public class StationView {

    public static String menuSelector(Scanner userInput) {
        String input = userInput.next();
        String thisMenuState = Constants.STATION_MENU_STATE;
        if (input.equals("1")) {
            insertStation(userInput);
        }
        if (input.equals("2")) {
            deleteStation(userInput);
        }
        if (input.equals("3")) {
            showStations();
        }
        if (input.toLowerCase().equals(Constants.BACKWARD_INPUT_CHARACTER)) {
            thisMenuState = Constants.MAIN_MENU_STATE;
        }
        if (!(input.equals("1") || input.equals("2") || input.equals("3")
            || input.toLowerCase().equals(Constants.BACKWARD_INPUT_CHARACTER))) {
            MessageUtils.printError(Constants.INVALID_STRING_OUTPUT_COMMENT);
        }
        return thisMenuState;
    }

    public static boolean insertStation(Scanner userInput) {
        MessageUtils.printInputAnnouncement(Constants.ADD_STATION_INPUT_COMMENT);
        String stationName = userInput.next();
        if (!InputUtils.isMinLengthString(stationName)) {
            MessageUtils.printError(Constants.INVALID_MIN_LENGTH_ERROR_COMMENT);
            return false;
        }
        if (isExistStationName(stationName)) {
            MessageUtils.printError(Constants.EXIST_STATION_OUTPUT_COMMENT);
            return false;
        }
        Station newStation = new Station(stationName);
        Subway.stations.addStation(newStation);
        MessageUtils.printInfo(Constants.ADD_STATION_OUTPUT_COMMENT);
        return true;
    }

    public static boolean isExistStationName(String stationName) {
        if (Subway.stations.findByName(stationName) == null) {
            return false;
        }
        return true;
    }

    public static void deleteStation(Scanner userInput) {
        MessageUtils.printInputAnnouncement(Constants.DELETE_STATION_INPUT_COMMENT);
        String targetStationName = userInput.next();
        Set<String> existStationInSection = Subway.Map.findIncludedStationSet();
        if (!existStationInSection.contains(targetStationName)) {
            deleteByName(targetStationName);
        }
        if (existStationInSection.contains(targetStationName)) {
            MessageUtils.printError(Constants.EXIST_STATION_IN_SECTION_OUTPUT_COMMENT);
        }
    }

    private static void deleteByName(String targetStationName) {
        if (Subway.stations.findByName(targetStationName) == null) {
            MessageUtils.printError(Constants.NO_EXIST_STATION_OUTPUT_COMMENT);
        }
        if (Subway.stations.findByName(targetStationName) != null) {
            Subway.stations.deleteStationByName(targetStationName);
            MessageUtils.printInfo(Constants.DELETE_STATION_OUTPUT_COMMENT);
        }
    }

    public static void showStations() {
        MessageUtils.printInputAnnouncement(Constants.TITLE_WHOLE_STATION_TEXT);
        for (Object station : Subway.stations.findAll()) {
            MessageUtils.printInfo((String) station);
        }
        MessageUtils.printBlankLine();
    }
}
