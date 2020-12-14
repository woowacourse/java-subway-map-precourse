package subway.domain;

import java.util.Scanner;
import subway.screen.MainScreen;

public class SubwayManager {
    private static MainScreen mainScreen;

    public SubwayManager() {
        mainScreen = new MainScreen();
    }

    public void execute(Scanner scanner) {
        do {
            mainScreen.startProcess(scanner);
        } while(!mainScreen.requestQuitMainScreen());
    }
}
