package subway.controller;

import subway.viewer.LineInputViewer;

import java.util.Scanner;

public class LineManager {
    private Scanner scanner;

    LineManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processSector() {
        LineInputViewer.askMainScreen();
        String option = scanner.next();
        LineOptions selectedOption = translateOption(option);
        checkValidatedOption(selectedOption);
    }

    private LineOptions translateOption(String option) {
        for (LineOptions lineOption : LineOptions.values()) {
            if (lineOption.getOption().equals(option)) {
                return lineOption;
            }
        }
        return null;
    }

    private void checkValidatedOption(LineOptions selectedOption) {
        if (selectedOption != null) {
            selectedOption.processUnit(scanner);
        }
    }
}
