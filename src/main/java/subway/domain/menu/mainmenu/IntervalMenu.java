package subway.domain.menu.mainmenu;

import subway.domain.MenuRepository;
import subway.userinterface.MenuInterface;
import subway.userinterface.Error;

import java.util.Scanner;

public class IntervalMenu implements Menu {
    public static final String MENU_BUTTON = "3";

    @Override
    public void run(Scanner scanner) {
        boolean runStatus = true;

        while (runStatus) {
            MenuInterface.printIntervalMenu();
            String intervalInput = scanner.next();
            runStatus = runIntervalMenu(scanner, intervalInput.toUpperCase());
        }
    }

    private boolean runIntervalMenu(Scanner scanner, String intervalInput) {
        if (Error.isWrongIntervalMenuInput(intervalInput)) {
            return true;
        }

        for (String key : MenuRepository.intervalMenu.keySet()) {
            if (intervalInput.equals(key)) {
                MenuRepository.intervalMenu.get(key).run(scanner);
                return true;
            }
        }
        return false;
    }
}
