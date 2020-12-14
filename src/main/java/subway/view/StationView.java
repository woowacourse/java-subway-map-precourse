package subway.view;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import subway.Subway;
import subway.domain.Station;
import subway.model.MenuGroup.Menu;
import subway.util.Constants;
import subway.util.DialogUtils;
import subway.util.InputUtils;
import subway.util.MessageUtils;

public class StationView extends AbstractView {

    private Map<String, Runnable> menuActionMap;

    public StationView(Subway subway, Scanner scanner) {
        super(subway, scanner);
    }

    @Override
    public void initView() {
        menuActionMap = Map.of(
            "1", this::insertStation,
            "2", this::deleteStation,
            "3", this::showStations,
            Constants.BACKWARD_INPUT_CHARACTER, this::goBackward
        );
    }

    @Override
    public Menu getMenu() {
        return Constants.MENU_GROUPS.get(Constants.STATION_MENU_STATE);
    }

    @Override
    public Map<String, Runnable> getMenuActionMap() {
        return menuActionMap;
    }

    private void insertStation() {
        try {
            String stationName = DialogUtils.ask(scanner, Constants.ADD_STATION_INPUT_COMMENT);
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
            String stationName = DialogUtils.ask(scanner, Constants.DELETE_STATION_INPUT_COMMENT);
            checkExistStationOrThrow(stationName);
            checkExistStationInSectionOrThrow(stationName);

            subway.getStationRepository().deleteStationByName(stationName);
            MessageUtils.printInfo(Constants.DELETE_STATION_OUTPUT_COMMENT);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
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
        return subway.getStationRepository().findByName(stationName) != null;
    }

    private void showStations() {
        MessageUtils.printAnnouncement(Constants.TITLE_WHOLE_STATION_TEXT);
        subway.getStationRepository().findAll()
            .forEach(station -> MessageUtils.printInfoEntry(station.getName()));
        MessageUtils.printBlankLine();
    }

}
