package subway.controller;

import subway.exception.SubwayException;
import subway.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    public static void run() {
        while (true) {
            try {
                OutputView.showMainMenu();
                MainMenu.findByCommand(InputView.nextLine()).run();
            } catch (SubwayException e) {
                OutputView.println(e.getMessage());
            }
        }
    }
}
