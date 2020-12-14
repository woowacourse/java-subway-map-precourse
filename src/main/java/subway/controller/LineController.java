package subway.controller;

import subway.service.LineService;
import subway.view.InputView;

import static subway.common.MenuPrinter.printLineControllerMenu;
import static subway.common.ServiceMenu.*;
import static subway.view.OutputView.warnMessage;

public class LineController {
    private final String OPTION_SELECT_WARN = "선택지 안의 기능을 선택해주세요.";

    public void service(InputView inputView) {
        String command;
        while(true) {
            printLineControllerMenu();
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
            addLine(inputView);
        }
        if (isDeleteCommand(command)) {
            deleteLine(inputView);
        }
        if (isPrintCommand(command)) {
            printLine();
        }
    }

    public void addLine(InputView inputView) {
        new LineService().addLine(inputView);
    }

    public void deleteLine(InputView inputView) {
        new LineService().deleteLine(inputView);
    }

    public void printLine() {
        new LineService().printLineList();
    }
}
