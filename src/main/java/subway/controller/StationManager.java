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
            StationInputViewer.askMainScreen();
            happenedError = checkSectorStatus();
        } while(happenedError);
    }

    private boolean checkSectorStatus() {
        try {
            String option = scanner.next();
            StationOptions selectedOption = translateOption(option);
            turnOption(selectedOption);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private StationOptions translateOption(String option) {
        for (StationOptions stationOption : StationOptions.values()) {
            if (stationOption.getOption().equals(option)) {
                return stationOption;
            }
        }
        System.out.println(SelectOptionConstants.OPTION_ERROR);
        System.out.println();
        throw new IllegalArgumentException();
    }

    private void turnOption(StationOptions selectedOption) {
        if (selectedOption != null) {
            selectedOption.processUnit(scanner);
        }
    }
}
