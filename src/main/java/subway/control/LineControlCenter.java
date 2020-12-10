package subway.control;

import subway.view.LineView;
import subway.view.MainView;
import subway.view.StationView;

import java.util.Scanner;

public class LineControlCenter {

    public LineControlCenter() {

    }

    public void startLineControl(Scanner scanner) {
        LineView.printLineMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
//        selectMenu(command, scanner);
    }
}
