package subway.managers;

import subway.domain.Line;
import subway.domain.Station;
import subway.exceptions.SubwayException;
import subway.exceptions.Validation;
import subway.views.SystemMessages;
import subway.views.SystemOutput;
import subway.views.UserInput;

import java.util.Scanner;

public class SectionManager {
    private static Validation validation = new Validation();

    public static void runSectionManager(Scanner scanner, UserInput userInput) {
        SystemOutput.printSectionMessage();
        String input = userInput.getInput();
        try {
            validation.sectionOptionValidation(input);
        } catch (SubwayException e) {
            runSectionManager(scanner, userInput);
        }

        if (input.equals("1")) {
            addSection(scanner, userInput);
        }
        if (input.equals("2")) {
            deleteSection(scanner, userInput);
        }
        if (input.equals("B")) {
            SubwayManager.runManager(scanner);
        }
    }

    static void addSection(Scanner scanner, UserInput userInput){
        SystemOutput.printMessage(SystemMessages.ADD_SECTION_LINE_MESSAGE);
        Line line = getLine(scanner, userInput);
        SystemOutput.printMessage(SystemMessages.ADD_SECTION_STATION_MESSAGE);
        Station station = getStation(scanner, userInput);
        int order = getOrder(scanner, userInput);
        line.addSection(order, station);
        SystemOutput.printInfo(SystemMessages.ADD_SECTION_COMPLETE_MESSAGE);
    }

    static void deleteSection(Scanner scanner, UserInput userInput){
        SystemOutput.printMessage(SystemMessages.DEL_SECTION_LINE_MESSAGE);
        Line line = getLine(scanner, userInput);
        SystemOutput.printMessage(SystemMessages.DEL_SECTION_STATION_MESSAGE);
        Station station = getStation(scanner, userInput);
        int order = getOrder(scanner, userInput);
        try {
            validation.sectionDeleteValidation(line);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
        line.deleteSection(order);
        SystemOutput.printInfo(SystemMessages.DEL_SECTION_COMPLETE_MESSAGE);
    }

    static Line getLine(Scanner scanner, UserInput userInput) {
        String lineName = userInput.getInput();
        try {
            return validation.isExistLine(lineName);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
        return null;
    }

    static Station getStation(Scanner scanner, UserInput userInput){
        String stationName = userInput.getInput();
        try {
            return validation.isExistStation(stationName);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
        return null;
    }

    static int getOrder(Scanner scanner, UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_SECTION_ORDER_MESSAGE);
        String input = userInput.getInput();
        try {
            validation.orderIsNumber(input);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        };
        return Integer.parseInt(input);
    }
}
