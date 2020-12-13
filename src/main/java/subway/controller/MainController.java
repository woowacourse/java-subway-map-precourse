package subway.controller;

import subway.domain.LineRepository;
import subway.menuType.MainMenuType;
import subway.view.menuView.MainView;

/**
 * Application.java
 * 메인 화면에서 기능을 선택할 수 있도록 합니다.
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class MainController {
    private static MainMenuType menu;
    private static MainView mainView = MainView.getInstance();

    public static void run() {
        do {
            mainView.printMenu();
            menu = mainView.getMenuSelection();
            runSelectedMenuFunction();
        } while (!menu.equals(MainMenuType.ESCAPE));
    }

    private static void runSelectedMenuFunction() {
        if (menu.equals(MainMenuType.STATION)) {
            StationManagement.run();
        }
        if (menu.equals(MainMenuType.LINE)) {
            LineManagement.run();
        }
        if (menu.equals(MainMenuType.SECTION)) {
            SectionManagement.run();
        }
        if (menu.equals(MainMenuType.PRINT)) {
            showSubwayMap();
        }
    }

    private static void showSubwayMap() {
        try {
            MainView.showSubwayMap(LineRepository.exprotsAllLinesToDTO());
        } catch (RuntimeException e) {
            mainView.printErrorMessage(e);
        }
    }
}
