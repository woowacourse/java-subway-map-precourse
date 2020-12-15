package subway.controller;

import subway.domain.LineRepository;
import subway.menuType.MainMenuType;
import subway.view.menuView.MainView;

import java.util.HashMap;

public class MainController {
    private static MainMenuType menu;
    private static MainView mainView = MainView.getInstance();
    private static HashMap<MainMenuType, matchedFunction> mapToFunction;

    static {
        MainController.mapToFunction = new HashMap<>();
        mapToFunction.put(MainMenuType.STATION, StationManagement::run);
        mapToFunction.put(MainMenuType.LINE, LineManagement::run);
        mapToFunction.put(MainMenuType.SECTION, SectionManagement::run);
        mapToFunction.put(MainMenuType.PRINT, MainController::showSubwayMap);
        mapToFunction.put(MainMenuType.ESCAPE, () -> {});
    }

    public static void run() {
        do {
            try {
                mainView.printMenu();
                menu = mainView.getMenuSelection();
                mapToFunction.get(menu).run();
            } catch (Exception e) {
                mainView.printErrorMessage(e);
            }
        } while (!menu.equals(MainMenuType.ESCAPE));
    }

    private static void showSubwayMap() {
        MainView.showSubwayMap(LineRepository.exprotsAllLinesToDTO());
    }
}
