package subway.userinterface;

import subway.domain.MenuRepository;

import java.util.Scanner;

public class UserController {
    private static boolean runStatus = true;

    public static void runApp(Scanner scanner) {
        while (runStatus) {
            ApplicationMenu.printMainMenu();
            runStatus = runMainMenu(scanner);
        }
    }

    private static boolean runMainMenu(Scanner scanner) {
        String mainInput = scanner.next();
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
