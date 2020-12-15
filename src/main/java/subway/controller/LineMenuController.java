package subway.controller;

import subway.menus.LineMenu;
import subway.service.lineservice.LineAddService;
import subway.service.lineservice.LineDeleteService;
import subway.service.lineservice.LinesPrintService;
import subway.views.lineviews.LineInputView;
import subway.views.lineviews.LineOutputView;

import java.util.Scanner;

public class LineMenuController implements Controller{
    private static final LineMenuController lineMenuController = new LineMenuController();

    private LineMenuController() {
    }

    public static LineMenuController getInstance() {
        return lineMenuController;
    }

    public void mappingMenu(Scanner scanner) {
          LineOutputView.printLineManagePage();
          branchBySelectedOption(scanner, LineInputView.selectLineMenu(scanner));
    }

    private void branchBySelectedOption(Scanner scanner, LineMenu selectedOption) {
        if (selectedOption.equals(LineMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        if (selectedOption.equals(LineMenu.LINE_ADD)) {
            LineAddService lineAddService = LineAddService.getInstance();
            lineAddService.lineAddService(scanner);
        }
        if (selectedOption.equals(LineMenu.LINE_DELETE)) {
            LineDeleteService lineDeleteService = LineDeleteService.getInstance();
            lineDeleteService.lineDeleteService(scanner);
        }
        if (selectedOption.equals(LineMenu.LINE_SELECT)) {
            LinesPrintService.showAllLines();
        }
    }
}
