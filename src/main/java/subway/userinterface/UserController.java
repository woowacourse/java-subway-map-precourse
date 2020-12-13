package subway.userinterface;

import subway.domain.MenuRepository;

import java.util.Scanner;

public class UserController {
    public static void runApp(Scanner scanner) {
        boolean runStatus = true;

        while (runStatus) {
            ApplicationMenu.printMainMenu();
            String mainInput = scanner.next();
            runStatus = runMainMenu(scanner, mainInput);
        }
    }

    private static boolean runMainMenu(Scanner scanner, String mainInput) {
        if (Error.isWrongMainMenuInput(mainInput)) {
            return true;
        }

        for (String key : MenuRepository.mainMenu.keySet()) {
            if (mainInput.equals(key)) {
                MenuRepository.mainMenu.get(key).run(scanner);
                return true;
            }
        }
        return false;
    }
}
