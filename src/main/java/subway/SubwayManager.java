package subway;

import java.util.Scanner;

public class SubwayManager {

    private BaseView nowView;
    private MainView mainView;

    public SubwayManager(Scanner scanner) {
        mainView = new MainView(scanner);
        nowView = mainView;
    }

    public void run() {
        nowView.printGuideMessage();
        String input = nowView.input();
    }
}
