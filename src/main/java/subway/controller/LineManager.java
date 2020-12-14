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
        } while(happenedError);
    }

    private boolean checkSectorStatus() {
        try {
            String option = scanner.next();
            LineOptions selectedOption = translateOption(option);
            turnOption(selectedOption);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
    private LineOptions translateOption(String option) {
        for (LineOptions lineOption : LineOptions.values()) {
            if (lineOption.getOption().equals(option)) {
                return lineOption;
            }
        }
        System.out.println(SelectOptionConstants.OPTION_ERROR);
        System.out.println();
        throw new IllegalArgumentException();
    }

    private void turnOption(LineOptions selectedOption) {
        if (selectedOption != null) {
            selectedOption.processUnit(scanner);
        }
    }
}
