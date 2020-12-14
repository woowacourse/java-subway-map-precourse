package subway.domain.menu.mainmenu;

import subway.domain.MenuRepository;
import subway.userinterface.MenuInterface;
import subway.userinterface.Error;

import java.util.Scanner;

public class LineMenu implements Menu {
    public static final String MENU_BUTTON = "2";

    @Override
    public void run(Scanner scanner) {
        boolean runStatus = true;

        while (runStatus) {
            MenuInterface.printLineMenu();
            String lineInput = scanner.next();
            runStatus = runLineMenu(scanner, lineInput.toUpperCase());
        }
    }

    private boolean runLineMenu(Scanner scanner, String lineInput) {
        if (Error.isWrongLineMenuInput(lineInput)) {
            return true;
        }

        for (String key : MenuRepository.stationMenu.keySet()) {
            if (lineInput.equals(key)) {
                MenuRepository.lineMenu.get(key).run(scanner);
                return true;
            }
        }
        return false;
    }
}
