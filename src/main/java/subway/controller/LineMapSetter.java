package subway.controller;

import subway.view.InputView;

public class LineMapSetter {

    private LineMapSetter() {
    }

    public static void run(InputView inputView) {
        Initializer.set();
        MenuController menuController = new MenuController(inputView);
        boolean ongoing;
        do {
            menuController.scanMenu();
            ongoing = menuController.runMenus();
            menuController.selectedMenus.clear();
        } while(ongoing);
    }
}
