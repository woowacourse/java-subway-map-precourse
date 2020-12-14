package subway.controller;

import subway.service.StationService;
import subway.view.InputView;

import java.util.Arrays;
import java.util.List;

import static subway.common.ServiceMenu.*;
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

    public void service(InputView inputView) {
        String command;
        while(true) {
            printMenuMessage(MENU_MESSAGES);
            command = inputView.inputName();
            if (isValidCommand(command)) {
                warnMessage(OPTION_SELECT_WARN);
                continue;
            }
            if (isBackCommand(command)) {
                break;
            }
            menuSelector(command, inputView);
        }
    }

    public void menuSelector(String command, InputView inputView) {
        if (isAddCommand(command)) {
            addStation(inputView);
        }
        if (isDeleteCommand(command)) {
            deleteStation(inputView);
        }
        if (isPrintCommand(command)) {
            printStation();
        }
    }

    public void addStation(InputView inputView) {
        new StationService().addStation(inputView);
    }

    public void deleteStation(InputView inputView) {
        new StationService().deleteStation(inputView);
    }

    public void printStation() {
        new StationService().printStationList();
    }
}
