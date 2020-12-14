package subway.domain.menu.stationmenu;

import subway.domain.StationRepository;
import subway.userinterface.ApplicationMenu;
import subway.userinterface.Error;
import subway.userinterface.Info;

import java.util.Scanner;

public class DeleteStationMenu implements StationManageMenu {
    public static final String MENU_BUTTON = "2";

    @Override
    public void run(Scanner scanner) {
        ApplicationMenu.printDeleteStation();

        String stationNameInput = scanner.next();
        if (Error.printNotExistStationError(stationNameInput) || Error.printStationAlreadyExistInLineError(stationNameInput)) {
            return;
        }
        StationRepository.deleteStationByName(stationNameInput);
        Info.printStationDeleted(stationNameInput);
    }
}
