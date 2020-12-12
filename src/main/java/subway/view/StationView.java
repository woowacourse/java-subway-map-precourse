package subway.view;

import java.util.List;
import subway.controller.StationController;
import subway.domain.Station;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class StationView {
    private final Input input;
    private final StationController stationController;

    public StationView(Input input) {
        this.input = input;
        this.stationController = new StationController();
    }

    public void selectStationMenu() {
        Message.printStatinMenu();
        selectMenu(input.nextStationButton());
    }

    private void selectMenu(String button) {
        if (isBack(button)) {
            return;
        }
        registerStation(button);
        deleteStation(button);
        readStations(button);
    }

    private boolean isBack(String button) {
        return button.equals(Button.BACK);
    }

    private void registerStation(String button) {
        if (button.equals(Button.ONE)) {
            Message.printCreateStation();
            String name = input.nextStation();
            if (!input.isValidNameLength(name)) {
                Message.printNameLengthError();
                selectStationMenu();
            }
            if (!input.isValidName(name)) {
                Message.printNameError();
                selectStationMenu();
            }
            stationController.createStation(name);
            Message.printSuccessStation();
        }
    }

    private void deleteStation(String button) {
        if (button.equals(Button.TWO)) {
            Message.printDeleteStation();
            String name = input.nextStation();
            if (!stationController.deleteStation(name)) {
                Message.printIsNotExist();
                return;
            }
            Message.deleteStationInfo();
        }
    }

    private void readStations(String button) {
        if (button.equals(Button.THREE)) {
            Message.printStations();
            List<Station> stations = stationController.readStations();
            for (Station station : stations) {
                Message.printStation(station.getName());
            }
        }
    }
}
