package subway;

import java.util.Scanner;
import subway.constant.UserChoiceOptionToName;
import subway.view.InputView;

public class SubwayController {

    Scanner scanner;

    public SubwayController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mainMenu() {
        String mainMenuOptionChoice = new String();
        while (!mainMenuOptionChoice.equals(
            UserChoiceOptionToName.EXIT.getUserChoiceOptionToName())) {
            mainMenuOptionChoice = InputView.scanMainMenu(scanner);
        }
    }
}
