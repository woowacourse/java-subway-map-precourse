package subway.controller;

import java.util.Scanner;
import subway.domain.StationRepository;
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
        return checkLength(name) && checkLastLetter(name) && checkAlreadyExist(name);
    }

    private boolean checkAlreadyExist(String name) {
        if (StationRepository.stationNames().contains(name)) {
            ErrorMessage.printValeAlreadyExist();
            return false;
        }
        return true;
    }

    private boolean checkLastLetter(String name) {
        if (name.charAt(name.length() - 1) != '역') {
            ErrorMessage.printLastLetterError();
            return false;
        }
        return true;
    }

    private boolean checkLength(String name) {
        if (name.length() < 2) {
            ErrorMessage.printNameLengthError();
            return false;
        }
        return true;
    }

}
