package subway.view;

import static subway.console.Button.BACK;
import static subway.console.Button.ONE;
import static subway.console.Button.THREE;
import static subway.console.Button.TWO;
import static subway.console.Output.print;
import static subway.console.Output.printStations;

import java.util.Arrays;
import java.util.List;
import subway.console.Input;
import subway.console.Output;
import subway.console.Page;
import subway.console.message.InfoMessage;
import subway.console.message.InputMessage;
import subway.controller.StationController;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class StationView {
    private static final List<String> STATION_BUTTONS = Arrays.asList(ONE, TWO, THREE, BACK);

    private final Input input;
    private final StationController stationController;

    public StationView(Input input) {
        this.input = input;
        this.stationController = new StationController();
    }

    public void selectStationPage() {
        String button = inputButton();
        while (isEndStationPage(button)) {
            button = inputButton();
        }
    }

    private boolean isEndStationPage(String button) {
        return !isCreate(button)
                && !isDelete(button)
                && !isRead(button)
                && !isBack(button);
    }

    private String inputButton() {
        Output.printPage(Page.STATION.getPages());
        return input.nextButton(STATION_BUTTONS);
    }

    private boolean isCreate(String button) {
        if (button.equals(ONE)) {
            print(InputMessage.CREATE_STATION.getMessage());
            if (isCreateStation()) {
                print(InfoMessage.CREATE_STATION.getMessage());
                return true;
            }
        }
        return false;
    }

    private boolean isCreateStation() {
        return stationController.createStation(input.nextLine());
    }

    private boolean isDelete(String button) {
        if (button.equals(TWO)) {
            print(InputMessage.DELETE_STATION.getMessage());
            if (isDeleteStation()) {
                print(InfoMessage.DELETE_STATION.getMessage());
                return true;
            }
        }
        return false;
    }

    private boolean isDeleteStation() {
        return stationController.deleteStation(input.nextLine());
    }

    private boolean isRead(String button) {
        if (button.equals(THREE)) {
            readStations();
            return true;
        }
        return false;
    }

    private void readStations() {
        printStations(stationController.getStations());
    }

    private boolean isBack(String button) {
        return button.equals(BACK);
    }
}
