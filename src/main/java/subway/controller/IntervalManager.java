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
        } while(happenedError);
    }

    private boolean checkSectorStatus() {
        try {
            String option = scanner.next();
            IntervalOptions selectedOption = translateOption(option);
            turnOption(selectedOption);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private IntervalOptions translateOption(String option) {
        for (IntervalOptions intervalOption : IntervalOptions.values()) {
            if (intervalOption.getOption().equals(option)) {
                return intervalOption;
            }
        }
        System.out.println(SelectOptionConstants.OPTION_ERROR);
        System.out.println();
        throw new IllegalArgumentException();
    }

    private void turnOption(IntervalOptions selectedOption) {
        if (selectedOption != null) {
            selectedOption.processUnit(scanner);
        }
    }
}
