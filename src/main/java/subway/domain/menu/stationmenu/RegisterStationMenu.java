package subway.domain.menu.stationmenu;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.userinterface.ApplicationMenu;
import subway.userinterface.Error;
import subway.userinterface.Info;

import java.util.Scanner;

public class RegisterStationMenu implements StationManageMenu {
    public static final String MENU_BUTTON = "1";

    @Override
    public void run(Scanner scanner) {
        ApplicationMenu.printAddStation();
        String stationNameInput = scanner.next();

        if (Error.printAlreadyExistStationError(stationNameInput)) {
            return;
        }
        StationRepository.addStation(new Station(stationNameInput));
        Info.printStationRegistered(stationNameInput);
    }
}
