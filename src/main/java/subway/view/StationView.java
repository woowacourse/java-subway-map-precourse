package subway.view;

import java.util.Scanner;
import java.util.Set;
import subway.SubwayLauncher;
import subway.domain.Station;
import subway.util.Constants;
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
        if (input.toLowerCase().equals("b")) {
            thisMenuState = Constants.MAIN_MENU_STATE;
        }
        if (!(input.equals("1") || input.equals("2") || input.equals("3")
            || input.toLowerCase().equals("b"))) {
            MessageUtils.printError(Constants.INVALID_STRING_OUTPUT_COMMENT);
        }
        return thisMenuState;
    }

    public static void insertStation(Scanner userInput) {
        MessageUtils.printAnnouncement(Constants.ADD_STATION_INPUT_COMMENT);
        String stationName = userInput.next();
        Station newStation = new Station(stationName);
        SubwayLauncher.stations.addStation(newStation);
        MessageUtils.printInfo(Constants.ADD_STATION_OUTPUT_COMMENT);
    }

    public static void deleteStation(Scanner userInput) {
        MessageUtils.printAnnouncement(Constants.DELETE_STATION_INPUT_COMMENT);
        String targetStationName = userInput.next();
        Set<String> existStationInSection = SubwayLauncher.subwayMap.findIncludedStationSet();
        if (!existStationInSection.contains(targetStationName)) {
            deleteByName(targetStationName);
        }
        if (existStationInSection.contains(targetStationName)) {
            MessageUtils.printError(Constants.EXIST_STATION_IN_SECTION_OUTPUT_COMMENT);
        }
    }

    private static void deleteByName(String targetStationName) {
        if (SubwayLauncher.stations.findByName(targetStationName) == null) {
            MessageUtils.printError(Constants.NO_EXIST_STATION_OUTPUT_COMMENT);
        }
        if (SubwayLauncher.stations.findByName(targetStationName) != null) {
            SubwayLauncher.stations.deleteStationByName(targetStationName);
            MessageUtils.printInfo(Constants.DELETE_STATION_OUTPUT_COMMENT);
        }
    }

    public static void showStations() {
        MessageUtils.printAnnouncement(Constants.TITLE_WHOLE_STATION_TEXT);
        for (Object station : SubwayLauncher.stations.findAll()) {
            MessageUtils.printInfo((String) station);
        }
    }
}
