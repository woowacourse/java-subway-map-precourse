package subway.controller;

import subway.controller.constants.SelectOptionConstants;
import subway.viewer.LineInputViewer;

import java.util.Scanner;

public class LineManager {
    private Scanner scanner;

    LineManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processSector() {
        boolean happenedError;
        do {
            LineInputViewer.askMainScreen();
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
        if (!SelectOptionConstants.LINE_OPTION.contains(unit)) {
            System.out.println();
            System.out.println(SelectOptionConstants.OPTION_ERROR);
            throw new IllegalArgumentException(SelectOptionConstants.OPTION_ERROR);
        }
    }

    private void goUnit(Scanner scanner, String unit) {
        for (LineSectors lineSector : LineSectors.values()) {
            filterUnit(lineSector, scanner, unit);
        }
    }

    private void filterUnit(LineSectors candidate, Scanner scanner, String unit) {
        if (candidate.getOption().equals(unit)) {
            candidate.processUnit(scanner);
        }
    }
}
