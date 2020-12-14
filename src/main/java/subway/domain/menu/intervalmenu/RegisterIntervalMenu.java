package subway.domain.menu.intervalmenu;

import subway.domain.LineRepository;
import subway.userinterface.ApplicationMenu;
import subway.userinterface.Error;
import subway.userinterface.Info;

import java.util.Scanner;

public class RegisterIntervalMenu implements IntervalManageMenu {
    public static final String MENU_BUTTON = "1";

    @Override
    public void run(Scanner scanner) {
        checkLineName(scanner);
    }

    private void checkLineName(Scanner scanner) {
        ApplicationMenu.printAddInterval_Line();
        String lineNameInput = scanner.next();
        if (Error.printNotExistLineError(lineNameInput)) {
            return;
        }

        checkStationName(scanner, lineNameInput);
    }

    private void checkStationName(Scanner scanner, String lineNameInput) {
        ApplicationMenu.printAddInterval_Station();
        String stationNameInput = scanner.next();
        if (Error.printNotExistStationError(stationNameInput) ||
                Error.printStationAlreadyExistInCertainLineError(lineNameInput, stationNameInput)) {
            return;
        }

        checkSequence(scanner, lineNameInput, stationNameInput);
    }

    private void checkSequence(Scanner scanner, String lineNameInput, String stationNameInput) {
        ApplicationMenu.printAddInterval_Sequence();
        int sequenceInput;
        try {
            sequenceInput = scanner.nextInt();
        } catch (Exception e) {
            Error.printNotIntInput();
            String trashCan = scanner.next();
            return;
        }
        if (Error.printIsWrongSequenceInput(lineNameInput, sequenceInput)) {
            return;
        }

        runRegisterInterval(lineNameInput, stationNameInput, sequenceInput);
    }

    private void runRegisterInterval(String lineNameInput, String stationNameInput, int sequenceInput) {
        LineRepository.addStationInLineByName(lineNameInput, stationNameInput, sequenceInput);
        Info.printIntervalRegistered(lineNameInput, stationNameInput);
    }
}
