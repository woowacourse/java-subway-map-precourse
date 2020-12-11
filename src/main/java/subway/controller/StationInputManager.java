package subway.controller;

import java.util.Scanner;
import subway.view.ErrorMessage;
import subway.view.Menu;

public class StationInputManager {

    private Scanner scanner;

    StationInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getStationName(String function) {
        while (true) {
            Menu.printStationGuide(function);
            String name = scanner.nextLine().trim();
            if (!checkName(name)) {
                continue;
            }
            return name;
        }


    }

    private boolean checkName(String name) {
        if (name.length() < 2) {
            ErrorMessage.printNameLengthError();
            return false;
        }
        return true;
    }

}
