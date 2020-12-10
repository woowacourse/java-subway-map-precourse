package subway;

import java.util.Scanner;
import subway.view.InputView;
import subway.view.OutputView;

public class Router {
    private static final String QUIT = "Q";
    private InputView inputView;

    public Router(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        String command = inputView.getMainScreenCommand();
        routeMainScreen(command);
    }

    private void routeMainScreen(String command) {
    }

}