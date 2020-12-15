package subway;

import java.util.Scanner;
import subway.migration.Migration;
import subway.ui.MainMenu;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Migration.run();
        MainMenu mainMenu = new MainMenu(scanner);
        mainMenu.run();
    }
}
