package subway.controller;

import subway.service.SectionService;
import subway.view.InputView;

import static subway.common.MenuPrinter.printSectionControllerMenu;
import static subway.common.ServiceMenu.*;
import static subway.view.OutputView.warnMessage;

public class SectionController extends BaseController{

    @Override
    public void service(InputView inputView) {
        String command;
        while(true) {
            printSectionControllerMenu();
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
            addSection(inputView);
        }
        if (isDeleteCommand(command)) {
            deleteSection(inputView);
        }
    }

    public void addSection(InputView inputView) {
        new SectionService().addSection(inputView);
    }

    public void deleteSection(InputView inputView) {
        new SectionService().deleteSection(inputView);
    }
}
