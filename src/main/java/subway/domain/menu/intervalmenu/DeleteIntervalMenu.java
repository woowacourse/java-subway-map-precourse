package subway.domain.menu.intervalmenu;

import subway.domain.LineRepository;
import subway.userinterface.MenuInterface;
import subway.userinterface.Error;
import subway.userinterface.Info;

import java.util.Scanner;

public class DeleteIntervalMenu implements IntervalManageMenu {
    public static final String MENU_BUTTON = "2";

    @Override
    public void run(Scanner scanner) {
        checkLineName(scanner);
    }

    private void checkLineName(Scanner scanner) {
        MenuInterface.printDeleteInterval_Line();
        String lineNameInput = scanner.next();
        if (Error.printNotExistLineError(lineNameInput) || Error.printNotEnoughStationInLineError(lineNameInput)) {
            return;
        }

        checkStationName(scanner, lineNameInput);
    }

    private void checkStationName(Scanner scanner, String lineNameInput) {
        MenuInterface.printDeleteInterval_Station();
        String stationNameInput = scanner.next();
        if (Error.printStationNotExistInCertainLineError(lineNameInput, stationNameInput)) {
            return;
        }

        runDeleteInterval(lineNameInput, stationNameInput);
    }

    private void runDeleteInterval(String lineNameInput, String stationNameInput) {
        LineRepository.deleteStationInLineByName(lineNameInput, stationNameInput);
        Info.printIntervalDeleted(lineNameInput, stationNameInput);
    }
}
