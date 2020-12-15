package subway.controller;

import subway.controller.constants.SelectOptionConstants;
import subway.viewer.StationInputViewer;

import java.util.Scanner;

public class StationManager {
    private Scanner scanner;

    StationManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processSector() {
        boolean happenedError;
        do {
            StationInputViewer.showMainScreen();
            happenedError = checkSectorStatus();
        } while (happenedError);
    }

    private boolean checkSectorStatus() {
        try {
            String unit = scanner.nextLine();
            isValidUnit(unit);
            goUnit(scanner, unit);
            return false;
        } catch (Exception error) {
            return true;
        }
    }

    private void isValidUnit(String unit) {
        if (!SelectOptionConstants.STATION_OPTION.contains(unit)) {
            System.out.println();
            System.out.println(SelectOptionConstants.OPTION_ERROR);
            throw new IllegalArgumentException(SelectOptionConstants.OPTION_ERROR);
        }
    }

    private void goUnit(Scanner scanner, String unit) {
        for (StationSectors stationOption : StationSectors.values()) {
            filterUnit(stationOption, scanner, unit);
        }
    }

    private void filterUnit(StationSectors candidate, Scanner scanner, String unit) {
        if (candidate.getOption().equals(unit)) {
            candidate.processUnit(scanner);
        }
    }
}
