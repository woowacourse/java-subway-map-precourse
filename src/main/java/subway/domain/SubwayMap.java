package subway.domain;

import subway.view.InputView;
import subway.view.screen.MainScreen;
import subway.view.screen.ScreenMapper;
import subway.view.screen.ScreenStack;

import java.util.Scanner;

public class SubwayMap {
    public static final void start(Scanner scanner) {
        Initializer.load();
        ScreenStack.pushScreen(new MainScreen());

        while(!ScreenStack.isEmpty()) {
            ScreenStack.show();
            ScreenStack.run(scanner);
        }
    }
}
