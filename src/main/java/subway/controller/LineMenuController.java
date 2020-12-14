package subway.controller;

import subway.menus.LineMenu;
import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class LineMenuController {
    private static LineMenuController lineMenuController = new LineMenuController();

    private LineMenuController() {
    }

    public static LineMenuController getInstance() {
        return lineMenuController;
    }

    public void mappingLineMenu(Scanner scanner) {
        OutputView.printLineManagePage();
        branchBySelectedOption(InputView.selectLineMenu(scanner));
    }

    private void branchBySelectedOption(LineMenu selectedOption) {
        if (selectedOption.equals(LineMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        if (selectedOption.equals(LineMenu.LINE_INSERT)) {

        }
        if (selectedOption.equals(LineMenu.LINE_DELETE)) {

        }
        if (selectedOption.equals(LineMenu.LINE_SELECT)) {

        }
    }
}
