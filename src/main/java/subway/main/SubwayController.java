package subway.main;

import subway.main.view.MainInputView;
import subway.main.view.MainOutputView;

public class SubwayController {
    public static void run(MainInputView mainInputView) {
        MainOutputView.printMainSelection();
        int option = mainInputView.selectOption();
    }
}
