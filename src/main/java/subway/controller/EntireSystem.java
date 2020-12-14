package subway.controller;

import subway.controller.constants.QuestionNumber;
import subway.viewer.SystemInputViewer;

import java.util.Scanner;

public class EntireSystem {
    private Scanner scanner;

    public EntireSystem(Scanner scanner) {
        this.scanner = scanner;
    }

    public void runProgram() {
        String option;
        do {
            SystemInputViewer.askMainScreen();
            option = scanner.next();
            EntireOptions selectedOption = translateOption(option);
            checkValidatedOption(selectedOption);
        } while (!option.equals(QuestionNumber.TERMINATE.getOption()));
    }

    private EntireOptions translateOption(String option) {
        for (EntireOptions entireOption : EntireOptions.values()) {
            if (entireOption.getOption().equals(option)) {
                return entireOption;
            }
        }
        return null;
    }

    private void checkValidatedOption(EntireOptions selectedOption) {
        if (selectedOption != null) {
            selectedOption.processSet(scanner);
        }
    }
}
