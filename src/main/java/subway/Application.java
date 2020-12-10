package subway;

import java.util.Scanner;
import subway.utils.ErrorUtils;
import subway.view.InputView;
import subway.view.screen.MainScreen;
import subway.view.screen.ScreenManager;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = InputView.of(scanner);
        DummyData.load();
        start(inputView);
    }

    public static void start(InputView inputView) {
        ScreenManager.push(new MainScreen());

        while (!ScreenManager.isEmpty()) {
            ErrorUtils.screenGoBackWhenException(() -> {
                ScreenManager.visualize();
                ScreenManager.logic(inputView);
            });
        }
    }
}
