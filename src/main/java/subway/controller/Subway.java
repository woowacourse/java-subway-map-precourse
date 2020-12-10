package subway.controller;

import java.util.Scanner;
import subway.exception.SubwayCustomException;
import subway.view.InputView;
import subway.view.MainMenu;
import subway.view.OutputView;

/**
 * 지하철 노선도 미션 총괄 클래스
 */
public class Subway {

    private final InputView inputView;
    private final Management management;

    public Subway(Scanner scanner) {
        inputView = new InputView(scanner);
        management = new Management(scanner);
    }

    public void start() {
        management.initialize();
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
            exception.getMessage();
            manage();
        }
    }
}
