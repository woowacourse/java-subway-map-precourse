package subway.controller;

import subway.viewer.IntervalInputViewer;

import java.util.Scanner;

public class IntervalManager {
    private Scanner scanner;

    IntervalManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processSector() {
        IntervalInputViewer.askMainScreen();
        String option = scanner.next();
        IntervalOptions selectedOption = translateOption(option);
        checkValidatedOption(selectedOption);
    }

    private IntervalOptions translateOption(String option) {
        for (IntervalOptions intervalOption : IntervalOptions.values()) {
            if (intervalOption.getOption().equals(option)) {
                return intervalOption;
            }
        }
        return null;
    }

    private void checkValidatedOption(IntervalOptions selectedOption) {
        if (selectedOption != null) {
            selectedOption.processUnit(scanner);
        }
    }
}
