package subway.userinterface.mainmenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

import java.util.Scanner;

public class MainViewInputController extends InputController {

    public MainViewInputController() {
        this.INPUT_INTRO = "\n## 원하는 기능을 선택하세요.";
    }

    protected void validateInput(Scanner scanner) {

        try {
            InputValidator.validateMainMenuInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getUserInput(scanner);
        }

    }
}
