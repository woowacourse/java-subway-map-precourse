package subway.controller;

import subway.domain.menu.MainMenuType;
import subway.domain.menu.SubMenuType;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineController implements Controller {
    private final Scanner scanner;
    private final LineService lineService;

    public LineController(Scanner scanner) {
        this.scanner = scanner;
        lineService = new LineService(scanner);
    }

    @Override
    public void runMenu(MainMenuType mainMenuType, String category) {
        SubMenuType subMenuType;
        do {
            subMenuType = InputView.inputStationOrLineMenuType(scanner, category, mainMenuType);
            selectMenu(subMenuType, category);
        } while (!subMenuType.equals(SubMenuType.BACK));
    }

    @Override
    public void selectMenu(SubMenuType lineMenuType, String category) {
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
