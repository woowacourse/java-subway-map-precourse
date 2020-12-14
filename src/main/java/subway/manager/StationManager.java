package subway.manager;

import subway.view.Output;
import subway.view.StationMenu;

import java.util.Scanner;

public class StationManager{

    public static void run(Scanner scanner) {
        Output.printNewLine();
        StationMenu.printMenu(scanner);
    }
}
