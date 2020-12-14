package subway.controller;

import subway.service.LineService;
import subway.view.InputView;

import static subway.common.MenuPrinter.printLineControllerMenu;
import static subway.common.ServiceMenu.*;
import static subway.view.OutputView.warnMessage;

public class LineController extends BaseController {

    @Override
    public void service(InputView inputView) {
        String command;
        while(true) {
            printLineControllerMenu();
            command = inputView.inputName();
            if (isValidCommand(command)) {
                warnMessage(COMMAND_SELECT_WARN);
                continue;
            }
            if (isBackCommand(command)) {
                break;
            }
            menuSelector(command, inputView);
        }
    }

    @Override
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
