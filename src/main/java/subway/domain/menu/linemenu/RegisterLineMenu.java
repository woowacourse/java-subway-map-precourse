package subway.domain.menu.linemenu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.userinterface.MenuInterface;
import subway.userinterface.Error;
import subway.userinterface.Info;

import java.util.Scanner;

public class RegisterLineMenu implements LineManageMenu {
    public static final String MENU_BUTTON = "1";

    @Override
    public void run(Scanner scanner) {
        checkLineName(scanner);
    }

    private void checkLineName(Scanner scanner) {
        MenuInterface.printAddLine();
        String lineNameInput = scanner.next();
        if (Error.printAlreadyExistLineError(lineNameInput)) {
            return;
        }

        checkDefaultStation(scanner, lineNameInput);
    }

    private void checkDefaultStation(Scanner scanner, String lineNameInput) {
        MenuInterface.printAddLine_StartStation();
        String startStationNameInput = scanner.next();
        if (Error.printNotExistStationError(startStationNameInput)) {
            return;
        }

        MenuInterface.printAddLine_EndStation();
        String endStationNameInput = scanner.next();
        if (Error.printNotExistStationError(endStationNameInput)) {
            return;
        }

        runRegisterLine(lineNameInput, startStationNameInput, endStationNameInput);
    }

    private void runRegisterLine(String lineNameInput, String startStationNameInput, String endStationNameInput) {
        LineRepository.addLine(new Line(lineNameInput), StationRepository.findStationByName(startStationNameInput),
                StationRepository.findStationByName(endStationNameInput));
        Info.printLineRegistered(lineNameInput);
    }
}
