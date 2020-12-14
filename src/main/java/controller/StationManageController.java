package controller;

import base.BaseController;
import base.BaseView;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManageController extends BaseController {
    public static final int INPUT_ADD_STATION = 1;
    public static final int INPUT_REMOVE_STATION = 2;
    public static final int INPUT_SEARCH_STATION = 3;

    public static final String INFO_PREFIX = "[INFO] ";
    public static final String MESSAGE_ADD_COMPLETE = "지하철 역이 등록되었습니다.";
    public static final String INPUT_MESSAGE_FOR_STATION_NAME = "## 등록할 역 이름을 입력하세요.";

    public StationManageController(BaseView view) {
        super(view);
    }


    public void processInput(int input) {
        if (input == INPUT_ADD_STATION) {
            addStation();
        }
        if (input == INPUT_REMOVE_STATION) {
            removeStation();
        }
        if (input == INPUT_SEARCH_STATION) {
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
    }

    private void removeStation() {

    }

    private void searchStation() {

    }

}
