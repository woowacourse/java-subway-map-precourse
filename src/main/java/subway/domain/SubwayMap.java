package subway.domain;

import subway.view.InputView;
import subway.view.MainScreen;
import subway.view.ScreenStack;

import java.util.Scanner;

public class SubwayMap {
    public static final void start(Scanner scanner) {
        ScreenStack.pushScreen(new MainScreen());
        ScreenStack.show();
        System.out.println(InputView.getCommand(ScreenStack.peek(), scanner));
    }
}
