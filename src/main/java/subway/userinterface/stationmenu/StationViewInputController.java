package subway.userinterface.stationmenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

import java.util.Scanner;

public class StationViewInputController extends InputController {

    public StationViewInputController() {
        this.INPUT_INTRO = "\n## 원하는 기능을 선택하세요.";
    }

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
