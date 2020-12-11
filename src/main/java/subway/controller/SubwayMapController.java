package subway.controller;

import subway.domain.LineStationFactory;
import subway.domain.LineStationRepository;
import subway.service.SubwayMapService;
import subway.utils.InputValidation;

import java.util.Scanner;

import static subway.domain.MenuType.MAIN_MENU_RANGE;
import static subway.domain.MenuType.MAIN_QUIT;
import static subway.view.InputView.inputSelectMenuRequestMessage;
import static subway.view.OutputView.printMainMenu;

public class SubwayMapController extends InputValidation {
    private final LineStationRepository lineStation;
    private final SubwayMapService subwayMapService;

    public SubwayMapController() {
        lineStation = new LineStationRepository(LineStationFactory.init());
        subwayMapService = new SubwayMapService();
    }

    public void run(Scanner scanner) {
        String menu = "";
        while (!menu.equals(MAIN_QUIT.getKey())) {
            printMainMenu();
            inputSelectMenuRequestMessage();
            menu = scanner.nextLine();
            validateMenuRange(MAIN_MENU_RANGE.getKeys(), menu);
            subwayMapService.selectMainMenu(scanner, menu, lineStation);
        }
    }
}