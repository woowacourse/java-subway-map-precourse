package subway.controller;

import java.util.Scanner;
import subway.controller.manager.LineManager;
import subway.controller.manager.MainManager;
import subway.exception.SubwayCustomException;
import subway.view.InputView;
import subway.menu.MainMenu;
import subway.view.OutputView;

/**
 * 지하철 노선도 미션 총괄 클래스
 */
public class SubwayController {

    private final MainManager mainManager;
    private final InputView inputView;

    public SubwayController(final InputView inputView){
        this.inputView = inputView;
        mainManager = new MainManager();
    }

    public void start() {
        mainManager.initialize();
        while (true) {
            OutputView.showMainMenu();
            manage();
        }
    }

    public void manage() {
        OutputView.chooseCategory();
        try {
            MainMenu.execute(inputView.inputValue());
        } catch (SubwayCustomException exception) {
            OutputView.showErrorMessage(exception);
            manage();
        }
    }


}
