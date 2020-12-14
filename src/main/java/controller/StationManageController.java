package controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import utils.ValidatorUtils;
import view.StationManageView;

public class StationManageController {
    public static final String INPUT_ADD_STATION = "1";
    public static final String INPUT_REMOVE_STATION = "2";
    public static final String INPUT_SEARCH_STATION = "3";

    public static final String ERROR_PREFIX = "\n[ERROR] ";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String ERROR_INVALID_INPUT = "유효하지 않은 입력입니다. \n";
    public static final String MESSAGE_ADD_COMPLETE = "지하철 역이 등록되었습니다.";
    public static final String INPUT_MESSAGE_FOR_STATION_NAME = "## 등록할 역 이름을 입력하세요.";

    private StationManageView view;

    public StationManageController(StationManageView view) {
        this.view = view;
    }

    public void processInput(String input) {
        if (!ValidatorUtils.validateInput(input)) {
            view.printMessage(ERROR_PREFIX + ERROR_INVALID_INPUT);
            view.run();
        }
        if (input.equals(INPUT_ADD_STATION)) {
            addStation();
        }
        if (input.equals(INPUT_REMOVE_STATION)) {
            removeStation();
        }
        if (input.equals(INPUT_SEARCH_STATION)) {
            searchStation();
        }
    }

    private void addStation() {
        view.printMessage(INPUT_MESSAGE_FOR_STATION_NAME);
        String input = view.input();

        if (StationRepository.isExistStation(input)) {
            return;
        }

        StationRepository.addStation(new Station(input));
        view.printMessage("\n" + INFO_PREFIX + MESSAGE_ADD_COMPLETE + "\n");
    }

    private void removeStation() {

    }

    private void searchStation() {

    }

    public boolean validateInput(String input) {
        return ValidatorUtils.validateInput(input);
    }

}
