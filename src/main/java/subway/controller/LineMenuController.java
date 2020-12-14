package subway.controller;

import subway.menus.LineMenu;
import subway.service.LineService;
import subway.views.lineviews.LineInputView;
import subway.views.lineviews.LineOutputView;

import java.util.Scanner;

public class LineMenuController {
    private static LineMenuController lineMenuController = new LineMenuController();
    private LineService lineService;

    private LineMenuController() {
    }

    public static LineMenuController getInstance() {
        return lineMenuController;
    }

    public void mappingLineMenu(Scanner scanner) {
          LineOutputView.printLineManagePage();
          lineService = new LineService(scanner);
          branchBySelectedOption(LineInputView.selectLineMenu(scanner));
    }

    private void branchBySelectedOption(LineMenu selectedOption) {
        if (selectedOption.equals(LineMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        if (selectedOption.equals(LineMenu.LINE_INSERT)) {
            lineService.lineAddService();
        }
        if (selectedOption.equals(LineMenu.LINE_DELETE)) {
            lineService.lineDeleteService();
        }
        if (selectedOption.equals(LineMenu.LINE_SELECT)) {
            lineService.showAllLines();
        }
    }
}
