package subway.controller;

import subway.service.StationService;
import subway.view.InputView;

import static subway.common.MenuPrinter.printStationControllerMenu;
import static subway.common.ServiceMenu.*;
import static subway.view.OutputView.warnMessage;

public class StationController {
    private final String OPTION_SELECT_WARN = "선택지 안의 기능을 선택해주세요.";

    public void service(InputView inputView) {
        String command;
        while(true) {
            printStationControllerMenu();
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
