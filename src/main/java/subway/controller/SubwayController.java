package subway.controller;

import subway.controller.manager.InitialManager;
import subway.exception.SubwayCustomException;
import subway.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

/**
 * 지하철 노선도 미션 총괄 클래스
 */
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
        OutputView.chooseCategory();
        try {
            MainMenu.execute(InputView.inputValue());
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manage();
        }
    }
}
