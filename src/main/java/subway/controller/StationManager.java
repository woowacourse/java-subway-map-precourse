package subway.controller;

import subway.viewer.StationInputViewer;

import java.util.Scanner;

public class StationManager {
    private Scanner scanner;

    StationManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processSector() {
        StationInputViewer.askMainScreen();
        String option = scanner.next();
        StationOptions selectedOption = translateOption(option);
        checkValidatedOption(selectedOption);
    }

    private StationOptions translateOption(String option) {
        for (StationOptions stationOption : StationOptions.values()) {
            if (stationOption.getOption().equals(option)) {
                return stationOption;
            }
        }
        return null;
    }

    private void checkValidatedOption(StationOptions selectedOption) {
        if (selectedOption != null) {
            selectedOption.processUnit(scanner);
        }
    }
}
