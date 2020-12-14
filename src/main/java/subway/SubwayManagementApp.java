package subway;

import subway.menu.MainMenu;
import java.util.Scanner;

public class SubwayManagementApp {
    private final Scanner scanner;

    public SubwayManagementApp(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        DummyData.initialize();
        MainMenu.run(scanner);
    }
}
