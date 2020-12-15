package subway.controller;

import subway.controller.constants.SelectOptionConstants;
import subway.viewer.IntervalInputViewer;

import java.util.Scanner;

public class IntervalManager {
    private Scanner scanner;

    IntervalManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processSector() {
        boolean happenedError;
        do {
            IntervalInputViewer.askMainScreen();
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
        if (!SelectOptionConstants.INTERVAL_OPTION.contains(unit)) {
            System.out.println(SelectOptionConstants.OPTION_ERROR);
            throw new IllegalArgumentException(SelectOptionConstants.OPTION_ERROR);
        }
    }

    private void goUnit(Scanner scanner, String unit) {
        for (IntervalSectors intervalSector : IntervalSectors.values()) {
            filterUnit(intervalSector, scanner, unit);
        }
    }

    private void filterUnit(IntervalSectors candidate, Scanner scanner, String unit) {
        if (candidate.getOption().equals(unit)) {
            candidate.processUnit(scanner);
        }
    }
}
