package subway.ui;

import java.util.Optional;
import java.util.Scanner;
import subway.message.ErrorMessage;

public class MainMenu {

    private final Scanner scanner;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            ConsoleOutput.printMainMenu();
            String userInput;
            try {
                userInput = ConsoleInput.scanLine(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
                continue;
            }
            Optional<MainMenuEnum> optional = MainMenuEnum.of(userInput);
            if (optional.isEmpty()) {
                ConsoleOutput.printErrorMessage(ErrorMessage.INPUT_INVALID_STRING.toString());
                continue;
            }
            MainMenuEnum mainMenuEnum = optional.get();
            if (mainMenuEnum.equals(MainMenuEnum.EXIT)) {
                break;
            }
            mainMenuEnum.action(scanner);
        }
    }
}
