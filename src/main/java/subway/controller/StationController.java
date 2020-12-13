package subway.controller;

import subway.service.StationService;
import subway.view.InputView;

import java.util.Arrays;
import java.util.List;

import static subway.view.OutputView.printMenuMessage;
import static subway.view.OutputView.warnMessage;

public class StationController {
    private final String STATION_MENU = "역 관리 화면";
    private final String ADD_STATION = "1. 역 등록";
    private final String DELETE_STATION = "2. 역 삭제";
    private final String PRINT_STATION = "3. 역 조회";
    private final String BACK = "B. 돌아가기";
    private final String OPTION_SELECT_WARN = "선택지 안의 기능을 선택해주세요.";
    private final List<String> MENU_MESSAGES =
            Arrays.asList(STATION_MENU, ADD_STATION, DELETE_STATION, PRINT_STATION, BACK);
    private final List<String> MENU_OPTIONS = Arrays.asList("1", "2", "3", "B");

    public void service(InputView inputView) {
        String option;
        while(true) {
            printMenuMessage(MENU_MESSAGES);
            option = inputView.inputName();
            if (!MENU_OPTIONS.contains(option)) {
                warnMessage(OPTION_SELECT_WARN);
                continue;
            }
            if (option.equals(BACK)) {
                break;
            }
            menuSelector(option, inputView);
        }
    }

    public void menuSelector(String option, InputView inputView) {
        if (option.equals(ADD_STATION)) {
            addStation(inputView);
        }
        if (option.equals(DELETE_STATION)) {
            deleteStation(inputView);
        }
        if (option.equals(PRINT_STATION)) {
            printStation();
        }
    }

    public void addStation(InputView inputView) {
        while (!new StationService().addStation(inputView)) {}
    }

    public void deleteStation(InputView inputView) {
        while (!new StationService().deleteStation(inputView)) {}
    }

    public void printStation() {
        new StationService().printStationList();
    }
}
