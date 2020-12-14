package subway.view;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import subway.Subway;
import subway.domain.Station;
import subway.util.Constants;
import subway.util.InputUtils;
import subway.util.MessageUtils;

public class StationView {

    private boolean isRunning = true;

    private Subway subway;
    private Scanner scanner;
    private Map<String, Runnable> menuActionMap;

    public StationView(Subway subway, Scanner scanner) {
        this.subway = subway;
        this.scanner = scanner;

        menuActionMap = Map.of(
            "1", this::insertStation,
            "2", this::deleteStation,
            "3", this::showStations,
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
        MessageUtils.printMenu(Constants.MENU_GROUPS.get(Constants.STATION_MENU_STATE));
        MessageUtils.printInputAnnouncement(Constants.ANNOUNCEMENT_FEATURE_SELECT_COMMENT);

        String input = scanner.next().toUpperCase();
        MessageUtils.printBlankLine();
        Runnable action = menuActionMap.get(input);

        if (action == null) {
            MessageUtils.printError(Constants.INVALID_STRING_OUTPUT_COMMENT);
            return;
        }
        action.run();
    }

    private void insertStation() {
        try {
            MessageUtils.printInputAnnouncement(Constants.ADD_STATION_INPUT_COMMENT);
            String stationName = scanner.next();
            MessageUtils.printBlankLine();
            checkValidationStationNameOrThrow(stationName);

            Station station = new Station(stationName);
            subway.getStationRepository().addStation(station);
            MessageUtils.printInfo(Constants.ADD_STATION_OUTPUT_COMMENT);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void deleteStation() {
        try {
            MessageUtils.printInputAnnouncement(Constants.DELETE_STATION_INPUT_COMMENT);
            String stationName = scanner.next();
            checkExistStationOrThrow(stationName);
            checkExistStationInSectionOrThrow(stationName);
            subway.getStationRepository().deleteStationByName(stationName);
            MessageUtils.printInfo(Constants.DELETE_STATION_OUTPUT_COMMENT);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    public void goBackward() {
        isRunning = false;
    }

    private void checkValidationStationNameOrThrow(String stationName) {
        InputUtils.isMinLengthString(stationName);
        if (isExistStation(stationName)) {
            throw new RuntimeException(Constants.EXIST_STATION_OUTPUT_COMMENT);
        }
    }

    private void checkExistStationOrThrow(String stationName) {
        if (!isExistStation(stationName)) {
            throw new RuntimeException(Constants.NO_EXIST_STATION_OUTPUT_COMMENT);
        }
    }

    private void checkExistStationInSectionOrThrow(String stationName) {
        Set<String> stationsInSection = subway.getSectionRepository().getSetStations();
        if (stationsInSection.contains(stationName)) {
            throw new RuntimeException(Constants.EXIST_STATION_IN_SECTION_OUTPUT_COMMENT);
        }
    }

    private boolean isExistStation(String stationName) {
        if (subway.getStationRepository().findByName(stationName) == null) {
            return false;
        }
        return true;
    }

    private void showStations() {
        MessageUtils.printInputAnnouncement(Constants.TITLE_WHOLE_STATION_TEXT);
        for (Object station : subway.getStationRepository().findAll()) {
            MessageUtils.printInfoEntry((String) station);
        }
        MessageUtils.printBlankLine();
    }

}
