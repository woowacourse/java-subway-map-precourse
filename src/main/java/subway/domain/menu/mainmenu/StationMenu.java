package subway.domain.menu.mainmenu;

import subway.domain.MenuRepository;
import subway.userinterface.MenuInterface;
import subway.userinterface.Error;

import java.util.Scanner;

public class StationMenu implements Menu {
    public static final String MENU_BUTTON = "1";

    @Override
    public void run(Scanner scanner) {
        boolean runStatus = true;

        while (runStatus) {
            MenuInterface.printStationMenu();
            String stationInput = scanner.next();
            runStatus = runStationMenu(scanner, stationInput.toUpperCase());
        }
    }

    private boolean runStationMenu(Scanner scanner, String stationInput) {
        if (Error.isWrongStationMenuInput(stationInput)) {
            return true;
        }

        for (String key : MenuRepository.stationMenu.keySet()) {
            if (stationInput.equals(key)) {
                MenuRepository.stationMenu.get(key).run(scanner);
                return true;
            }
        }
        return false;
    }

}
