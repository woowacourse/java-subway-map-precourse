package subway;

import java.util.Scanner;

public class SubwayMapProgram {

    public void start(Scanner scanner) {
        String mainInput = "";
        while (true) {
            PrintMainScreen.printMainScreen();
            PrintUserSelectionMessage.printUserSelectionMessage();
            mainInput = scanner.nextLine();
            if (mainInput.equals(MainSelection.QUIT)) {
                break;
            }
            resolveMainScreenInput(mainInput);
        }
    }

    private void resolveMainScreenInput(String mainInput) {
        if (mainInput.equals(MainSelection.STATION_MANAGEMENT)) {
            StationManagement.start();
        }
        if (mainInput.equals(MainSelection.LINE_MANAGEMENT)) {
            LineManagement.start();
        }
        if (mainInput.equals(MainSelection.SECTION_MANAGEMENT)) {
            SectionManagement.start();
        }
        if (mainInput.equals(MainSelection.PRINT_SUBWAY_MAP)) {
            PrintSubwayMap.start();
        }
    }
}
