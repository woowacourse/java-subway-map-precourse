package subway.controller;

import java.util.Scanner;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.ErrorMessage;
import subway.view.Menu;

public class LineInputManager {

    private Scanner scanner;

    public LineInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getLineInput(String function) {
        while (true) {
            Menu.printLineGuide(function);
            String name = scanner.nextLine().trim();
            if (!checkName(name)) {
                continue;
            }
            return name;
        }
    }

    private boolean checkName(String name) {
        return checkLastLetter(name) && checkAlreadyExist(name);
    }

    private boolean checkAlreadyExist(String name) {
        if (LineRepository.lineNames().contains(name)) {
            ErrorMessage.printValeAlreadyExist();
            return false;
        }
        return true;
    }

    private boolean checkLastLetter(String name) {
        if (name.substring(name.length() - 3).equals("호선")) {
            ErrorMessage.printLastLetterLine();
            return false;
        }
        return true;
    }

}
