package subway;

import java.util.Scanner;

public class SubwayMapProgram {

    public void start(Scanner scanner) {
        String mainInput = "";
        while (true) {
            PrintMainScreen.printMainScreen();
            Printer.printUserFunctionSelectionMessage();
            mainInput = scanner.nextLine();
            if (mainInput.equals(UserSelections.QUIT)) {
                break;
            }
            resolveMainScreenInput(mainInput, scanner);
        }
    }

    private void resolveMainScreenInput(String mainInput, Scanner scanner) {
        if (mainInput.equals(UserSelections.FIRST)) {
            StationManagement.start(scanner);
        }
        if (mainInput.equals(UserSelections.SECOND)) {
            LineManagement.start(scanner);
        }
        if (mainInput.equals(UserSelections.THIRD)) {
            SectionManagement.start(scanner);
        }
        if (mainInput.equals(UserSelections.GO_BACK)) {
            PrintSubwayMap.start(scanner);
        }
    }
}
