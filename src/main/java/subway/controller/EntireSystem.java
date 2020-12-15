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
        String sector;
        do {
            SystemInputViewer.askMainScreen();
            sector = scanner.nextLine();
            isValidSector(sector);
            goSector(sector);
        } while (!sector.equals(QuestionNumber.TERMINATE.getOption()));
    }

    private void isValidSector(String sector) {
        try {
            isContainSectorList(sector);
        } catch (Exception error) {
            System.out.println();
            System.out.println(SelectOptionConstants.OPTION_ERROR);
        }
    }

    private void isContainSectorList(String sector) {
        if (!SelectOptionConstants.ENTIRE_SECTOR.contains(sector)) {
            throw new IllegalArgumentException(SelectOptionConstants.OPTION_ERROR);
        }
    }

    private void goSector(String sector) {
        for (EntireSet entireOption : EntireSet.values()) {
            filterSector(entireOption, scanner, sector);
        }
    }

    private void filterSector(EntireSet candidate, Scanner scanner, String option) {
        if (candidate.getOption().equals(option)) {
            candidate.processSet(scanner);
        }
    }
}
