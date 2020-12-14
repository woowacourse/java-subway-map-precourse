package subway;

import subway.view.navigationViews.MainView;

import java.util.Scanner;

public class SubwayManager {
    public static void run(Scanner scanner) {
        DummyData.insert();
        MainView mainView = new MainView(scanner);
        mainView.show();
    }
}
