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

    public void selectStationMenu(String button) {
        while (!isBack(button)) {
            if (isCreate(button)) {
                break;
            }
            if (isDelete(button)) {
                break;
            }
            if (isRead(button)) {
                break;
            }
            button = input.nextStationButton();
        }
    }

    private boolean isBack(String button) {
        return button.equals(Button.BACK);
    }

    private boolean isCreate(String button) {
        if (button.equals(Button.ONE)) {
            return registerStation();
        }
        return false;
    }

    private boolean registerStation() {
        Message.printCreateStation();
        String name = input.nextStation();
        if (!input.validName(name)) {
            return false;
        }
        stationController.createStation(name);
        Message.printSuccessStation();
        return true;
    }

    private boolean isDelete(String button) {
        if (button.equals(Button.TWO)) {
            return deleteStation();
        }
        return false;
    }

    private boolean deleteStation() {
        Message.printDeleteStation();
        if (stationController.deleteStation(input.nextStation())) {
            Message.deleteStationInfo();
            return true;
        }
        Message.printIsNotExist();
        return false;
    }

    private boolean isRead(String button) {
        if (button.equals(Button.THREE)) {
            readStations();
            return true;
        }
        return false;
    }

    private void readStations() {
        Message.printStations();
        List<Station> stations = stationController.readStations();
        for (Station station : stations) {
            Message.printStation(station.getName());
        }
    }
}
