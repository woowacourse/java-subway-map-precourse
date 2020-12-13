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

    private boolean insertStation() {
        MessageUtils.printInputAnnouncement(Constants.ADD_STATION_INPUT_COMMENT);
        String stationName = scanner.next();
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

    private void deleteStation() {
        MessageUtils.printInputAnnouncement(Constants.DELETE_STATION_INPUT_COMMENT);
        String targetStationName = scanner.next();
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

    public void goBackward() {
        isRunning = false;
    }
}
