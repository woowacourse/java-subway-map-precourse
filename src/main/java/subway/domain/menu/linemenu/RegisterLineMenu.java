package subway.domain.menu.linemenu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.userinterface.ApplicationMenu;
import subway.userinterface.Error;
import subway.userinterface.Info;

import java.util.Scanner;

public class RegisterLineMenu implements LineManageMenu {
    public static final String MENU_BUTTON = "1";

    @Override
    public void run(Scanner scanner) {
        ApplicationMenu.printAddLine();
        checkLineName(scanner);
    }

    private void checkLineName(Scanner scanner) {
        String lineNameInput = scanner.next();
        if (Error.printAlreadyExistLineError(lineNameInput)) {
            return;
        }
        checkDefaultStation(scanner, lineNameInput);
    }

    private void checkDefaultStation(Scanner scanner, String lineNameInput) {
        ApplicationMenu.printAddLine_StartStation();
        String startStationNameInput = scanner.next();
        if (Error.printNotExistStationError(startStationNameInput)) {
            return;
        }

        ApplicationMenu.printAddLine_EndStation();
        String endStationNameInput = scanner.next();
        if (Error.printNotExistStationError(endStationNameInput)) {
            return;
        }

        runRegisterLine(scanner, lineNameInput, startStationNameInput, endStationNameInput);
    }

    private void runRegisterLine(Scanner scanner, String lineNameInput, String startStationNameInput, String endStationNameInput) {
        LineRepository.addLine(new Line(lineNameInput), StationRepository.findStationByName(startStationNameInput), StationRepository.findStationByName(endStationNameInput));
        Info.printLineRegistered(lineNameInput);
    }
}
