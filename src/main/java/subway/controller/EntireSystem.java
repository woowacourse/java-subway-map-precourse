package subway.controller;

import subway.controller.constants.QuestionNumber;
import subway.controller.constants.SelectOptionConstants;
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
            isValidatedOption(option);
            EntireOptions selectedOption = translateOption(option);
            turnOption(selectedOption);
        } while (!option.equals(QuestionNumber.TERMINATE.getOption()));
    }

    private void isValidatedOption(String option) {
        try {
            isContainOptionList(option);
        }catch (Exception e) {
            System.out.println(SelectOptionConstants.OPTION_ERROR);
            System.out.println();
        }
    }

    private void isContainOptionList(String option) {
        if (!SelectOptionConstants.ENTIRE_OPTION.contains(option)) {
            throw new IllegalArgumentException();
        }
    }

    private EntireOptions translateOption(String option) {
        for (EntireOptions entireOption : EntireOptions.values()) {
            if (entireOption.getOption().equals(option)) {
                return entireOption;
            }
        }
        return null;
    }

    private void turnOption(EntireOptions selectedOption) {
        if (selectedOption != null) {
            selectedOption.processSet(scanner);
        }
    }
}
