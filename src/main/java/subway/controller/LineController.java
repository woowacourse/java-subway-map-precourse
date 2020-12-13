package subway.controller;

import subway.domain.menu.MainMenuType;
import subway.domain.menu.SubMenuType;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineController {
    private final Scanner scanner;
    private final LineService lineService;

    public LineController(Scanner scanner) {
        this.scanner = scanner;
        lineService = new LineService(scanner);
    }

    public void runLineMenu(MainMenuType mainMenuType, String category) {
        SubMenuType subMenuType;
        do {
            subMenuType = InputView.inputStationOrLineMenu(scanner, category, mainMenuType);
            selectLineMenu(subMenuType, category);
        } while (!subMenuType.equals(SubMenuType.BACK));
    }

    private void selectLineMenu(SubMenuType lineMenuType, String category) {
        if (SubMenuType.ADD.equals(lineMenuType)) {
            lineService.addLineInLineRepository(category);
            return;
        }
        if (SubMenuType.DELETE.equals(lineMenuType)) {
            lineService.deleteLineInLineRepository(category);
            return;
        }
        if (SubMenuType.LIST_PRINT.equals(lineMenuType)) {
            OutputView.printLineList(category);
        }
    }
}
