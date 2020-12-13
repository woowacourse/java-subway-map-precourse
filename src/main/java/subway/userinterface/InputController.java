package subway.userinterface;

import java.util.Scanner;

public abstract class InputController {

    private final static String MAIN_INPUT = "\n## 원하는 기능을 선택하세요.";
    protected static String userInput;

    public void getUserInput(Scanner scanner) {

        System.out.println(MAIN_INPUT);
        userInput = scanner.nextLine();
        validateInput(scanner);
    }

    protected abstract void validateInput(Scanner scanner);

}
