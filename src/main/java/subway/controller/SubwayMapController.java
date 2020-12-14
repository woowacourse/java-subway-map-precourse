package subway.controller;

import subway.domain.LineStationFactory;
import subway.domain.LineStationRepository;
import subway.service.InputService;
import subway.service.SubwayMapService;

import java.util.Scanner;

import static subway.domain.MenuType.MAIN_MENU_RANGE;
import static subway.domain.MenuType.MAIN_QUIT;
import static subway.view.OutputView.printMainMenu;

public class SubwayMapController extends InputService {
    private final LineStationRepository lineStation;
    private final SubwayMapService subwayMapService;

    public SubwayMapController() {
        lineStation = new LineStationRepository(LineStationFactory.init());
        subwayMapService = new SubwayMapService();
    }

    public void run(Scanner scanner) {
        String menu = "";
        while (!MAIN_QUIT.isKeyEquals(menu)) {
            printMainMenu();
            menu = inputSelectMenu(scanner, MAIN_MENU_RANGE);
            subwayMapService.selectMainMenu(scanner, menu, lineStation);
        }
    }
}