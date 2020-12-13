package subway.userinterface.stationmenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

import java.util.Scanner;

public class StationViewInputController extends InputController {

    @Override
    protected void validateInput(Scanner scanner) {
        try {
            InputValidator.validateSubMenuInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getUserInput(scanner);
        }
    }

}
