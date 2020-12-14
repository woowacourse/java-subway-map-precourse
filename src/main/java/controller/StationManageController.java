package controller;

import java.util.Map;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import utils.ValidateUtils;
import view.StationManageView;

public class StationManageController {
    public static final String INPUT_ADD_STATION = "1";
    public static final String INPUT_REMOVE_STATION = "2";
    public static final String INPUT_SHOW_STATIONS = "3";

    public static final String ERROR_PREFIX = "\n[ERROR] ";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String ERROR_INVALID_INPUT = "유효하지 않은 입력입니다. \n";
    public static final String ERROR_DUPLICATE_STATION_NAME = "이미 등록된 역이 존재합니다. \n";
    public static final String ERROR_STATION_NAME_LESS_THAN_TWO = "역이름은 2글자 이상이여야 합니다. \n";
    public static final String ERROR_STATION_NAME_NOT_EXIST = "해당 역이 존재하지 않습니다. \n";
    public static final String ERROR_STATION_IN_LINES = "노선에 존재하는 역은 삭제할 수 없습니다. \n";
    public static final String COMPLETE_REMOVE_STATION = "지하철 역이 삭제되었습니다.";
    public static final String MESSAGE_ADD_COMPLETE = "지하철 역이 등록되었습니다.";
    public static final String INPUT_MESSAGE_FOR_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    public static final String INPUT_MESSAGE_FOR_STATION_NAME_TO_DELETE = "## 삭제할 역 이름을 입력하세요.";

    private StationManageView view;

    public StationManageController(StationManageView view) {
        this.view = view;
    }

    public void processInput(String input) {
        if (!ValidateUtils.validateInput(input)) {
            view.printMessage(ERROR_PREFIX + ERROR_INVALID_INPUT);
            view.run();
        }
        if (input.equals(INPUT_ADD_STATION)) {
            addStation();
        }
        if (input.equals(INPUT_REMOVE_STATION)) {
            removeStation();
        }
        if (input.equals(INPUT_SHOW_STATIONS)) {
            showStations();
        }
    }

    private void addStation() {
        view.printMessage(INPUT_MESSAGE_FOR_STATION_NAME);
        String input = view.input();
        if (!ValidateUtils.validateStationName(input)) {
            view.printMessage(ERROR_STATION_NAME_LESS_THAN_TWO);
            return;
        }
        if (StationRepository.isExistStation(input)) {
            view.printMessage(ERROR_DUPLICATE_STATION_NAME);
            return;
        }
        StationRepository.addStation(new Station(input));
        view.printMessage("\n" + INFO_PREFIX + MESSAGE_ADD_COMPLETE + "\n");
    }

    private void removeStation() {
        view.printMessage(INPUT_MESSAGE_FOR_STATION_NAME_TO_DELETE);
        String input = view.input();

        if (!StationRepository.isExistStation(input)) {
            view.printMessage(ERROR_STATION_NAME_NOT_EXIST);
            return;
        }
        if (LineRepository.isStationInLines(StationRepository.getStationByName(input))) {
            view.printMessage(ERROR_STATION_IN_LINES);
        }
        if (StationRepository.deleteStation(input)) {
            view.printMessage(COMPLETE_REMOVE_STATION);
        }

        StationRepository.deleteStation(input);
    }

    private void showStations() {
        Map<String, Station> map = StationRepository.stations();
        for (Station station : map.values()) {
            view.printMessage(INFO_PREFIX + station.getName());
        }
    }

    public boolean validateInput(String input) {
        return ValidateUtils.validateInput(input);
    }

}
