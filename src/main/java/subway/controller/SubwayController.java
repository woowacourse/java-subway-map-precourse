package subway.controller;

import subway.controller.manager.InitialManager;
import subway.exception.SubwayCustomException;
import subway.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InitialManager initialManager;

    public SubwayController() {
        initialManager = new InitialManager();
    }

    public void start() {
        initialManager.initialize();
        while (true) {
            OutputView.showMainMenu();
            manage();
        }
    }

    public void manage() {
        try {
            OutputView.chooseCategory();
            MainMenu.execute(InputView.inputValue());
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manage();
        }
    }
}
