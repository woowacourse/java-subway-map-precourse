package subway.userinterface.mainmenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

import java.util.Scanner;

public class MainViewInputController extends InputController {

    protected void validateInput(Scanner scanner) {

        try {
            InputValidator.validateMainMenuInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getUserInput(scanner);
        }

    }
}
