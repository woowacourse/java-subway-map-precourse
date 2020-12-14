package subway.view;

import java.util.Map;
import java.util.Scanner;
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
            String stationName = DialogUtils.ask(scanner, Constants.ADD_STATION_ASK);
            checkValidationStationNameOrThrow(stationName);

            Station station = new Station(stationName);
            subway.getStationRepository().addStation(station);
            MessageUtils.printInfo(Constants.ADDED_STATION);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void deleteStation() {
        try {
            String stationName = DialogUtils.ask(scanner, Constants.DELETE_STATION_ASK);
            checkExistStationOrThrow(stationName);
            checkExistStationInSectionOrThrow(stationName);

            subway.getStationRepository().deleteStationByName(stationName);
            MessageUtils.printInfo(Constants.DELETED_STATION);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void checkValidationStationNameOrThrow(String stationName) {
        InputUtils.checkMinLengthOrThrow(stationName);
        if (subway.getStationRepository().isExistByName(stationName)) {
            throw new RuntimeException(Constants.EXIST_STATION);
        }
    }

    private void checkExistStationOrThrow(String stationName) {
        if (!subway.getStationRepository().isExistByName(stationName)) {
            throw new RuntimeException(Constants.NO_EXIST_STATION);
        }
    }

    private void checkExistStationInSectionOrThrow(String stationName) {
        Station station = subway.getStationRepository().findByName(stationName);
        if (subway.getSectionRepository().findAllStations().contains(station)) {
            throw new RuntimeException(Constants.EXIST_STATION_IN_SECTION);
        }
    }

    private void showStations() {
        MessageUtils.printAnnouncement(Constants.TITLE_STATION_LIST);
        subway.getStationRepository().findAll()
            .forEach(station -> MessageUtils.printInfoEntry(station.getName()));
        MessageUtils.printBlankLine();
    }
}
