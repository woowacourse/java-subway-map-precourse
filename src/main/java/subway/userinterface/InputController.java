package subway.userinterface;

import java.util.Scanner;

public abstract class InputController {
    protected String INPUT_INTRO;
    protected String userInput;

    public String getUserInput(Scanner scanner) {
        System.out.println(INPUT_INTRO);
        userInput = scanner.nextLine().replace(" ", "");
        validateInput();

        return userInput;
    }

    protected abstract void validateInput();
}
