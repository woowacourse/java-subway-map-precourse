package controller;

import java.util.Map;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import utils.ConstantsString;
import utils.ValidateUtils;
import view.StationManageView;

public class StationManageController {

    private StationManageView view;

    public StationManageController(StationManageView view) {
        this.view = view;
    }

    public void processInput(String input) {
        if (input.equals(ConstantsString.INPUT_ADD_STATION)) {
            addStation();
        }
        if (input.equals(ConstantsString.INPUT_REMOVE_STATION)) {
            removeStation();
        }
        if (input.equals(ConstantsString.INPUT_SHOW_STATIONS)) {
            showStations();
        }
    }

    private void addStation() {
        view.printMessage(ConstantsString.INPUT_MESSAGE_FOR_STATION_NAME);
        String input = view.input();
        if (!ValidateUtils.validateLengthMoreThanTwo(input)) {
            view.printMessage(ConstantsString.ERROR_STATION_NAME_LESS_THAN_TWO);
            return;
        }
        if (StationRepository.isExistStation(input)) {
            view.printMessage(ConstantsString.ERROR_DUPLICATE_STATION_NAME);
            return;
        }
        StationRepository.addStation(new Station(input));
        view.printMessage("\n" + ConstantsString.MESSAGE_ADD_COMPLETE + "\n");
    }

    private void removeStation() {
        view.printMessage(ConstantsString.INPUT_MESSAGE_FOR_STATION_NAME_TO_DELETE);
        String input = view.input();

        if (!StationRepository.isExistStation(input)) {
            view.printMessage(ConstantsString.ERROR_STATION_NAME_NOT_EXIST);
            return;
        }
        if (LineRepository.isStationInLines(StationRepository.getStationByName(input))) {
            view.printMessage(ConstantsString.ERROR_STATION_IN_LINES);
        }
        if (StationRepository.deleteStation(input)) {
            view.printMessage(ConstantsString.COMPLETE_REMOVE_STATION);
        }

        StationRepository.deleteStation(input);
    }

    private void showStations() {
        Map<String, Station> map = StationRepository.stations();
        for (Station station : map.values()) {
            view.printMessage(ConstantsString.INFO_PREFIX + station.getName());
        }
    }

    public boolean validateInput(String input) {
        return ValidateUtils.validateInput(input);
    }

}
