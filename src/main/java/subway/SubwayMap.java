package subway;

import subway.manager.MainManager;
import subway.view.Input;

import java.util.Scanner;

public class SubwayMap {

    public void run(Scanner scanner) {
        init(scanner);
        MainManager.run();
    }

    private void init(Scanner scanner) {
        Input.init(scanner);
    }
}
