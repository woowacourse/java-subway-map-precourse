package subway;

import java.util.Scanner;
import subway.view.Input;
import subway.view.MainView;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class SubwayApplication {
    private final MainView mainView;

    public SubwayApplication(Scanner scanner) {
        mainView = new MainView(new Input(scanner));
    }

    public void run() {
        mainView.selectMainMenu();
    }
}
