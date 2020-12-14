package subway.controller;

import subway.view.InputView;

import static subway.common.ControllerMenu.*;
import static subway.common.MenuPrinter.printMainControllerMenu;
import static subway.repository.LineRepository.printLineAndStation;
import static subway.view.OutputView.warnMessage;

public class MainController extends BaseController{

    @Override
    public void service(InputView inputView) {
        String command;
        while(true) {
            printMainControllerMenu();
            command = inputView.inputName();
            if (isValidCommand(command)) {
                warnMessage(COMMAND_SELECT_WARN);
                continue;
            }
            if (isExitCommand(command)) {
                break;
            }
            menuSelector(command, inputView);
        }
    }

    @Override
    public void menuSelector(String command, InputView inputView) {
        if (isStationControllerCommand(command)) {
            new StationController().service(inputView);
        }
        if (isLineControllerCommand(command)) {
            new LineController().service(inputView);
        }
        if (isSectionControllerCommand(command)) {
            new SectionController().service(inputView);
        }
        if (isPrintSubwayCommand(command)) {
            printLineAndStation();
        }
    }
}
