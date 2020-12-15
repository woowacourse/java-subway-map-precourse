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
    private static Line line;
    private static Station station;
    private static int order;
    private static boolean flag = true;

    public static void runSectionManager(Scanner scanner, UserInput userInput) {
        SystemOutput.printSectionMessage();
        String input = userInput.getInput();
        try {
            validation.sectionOptionValidation(input);
        } catch (SubwayException e) {
            runSectionManager(scanner, userInput);
        }
        if (input.equals("1")) {
            getLine(scanner, userInput, true);
        }
        if (input.equals("2")) {
            getLine(scanner, userInput);
        }
        if (input.equals("B")) {
            SubwayManager.runManager(scanner);
        }
    }


    static void addSection(Scanner scanner){
        try {
            validation.sectionDuplication(line, station, order);
            line.addSection(order, station);
            SystemOutput.printInfo(SystemMessages.ADD_SECTION_COMPLETE_MESSAGE);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
    }

    static void deleteSection(Scanner scanner){
        try {
            validation.sectionDeleteValidation(line);
            line.deleteSection(order);
            SystemOutput.printInfo(SystemMessages.DEL_SECTION_COMPLETE_MESSAGE);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
    }

    static void getLine(Scanner scanner, UserInput userInput, boolean flag) {
        SystemOutput.printMessage(SystemMessages.ADD_SECTION_LINE_MESSAGE);
        String lineName = userInput.getInput();
        try {
            line = validation.isExistLine(lineName);
            getStation(scanner, userInput, flag);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
    }

    static void getLine(Scanner scanner, UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.DEL_SECTION_LINE_MESSAGE);
        String lineName = userInput.getInput();
        try {
            line = validation.isExistLine(lineName);
            getStation(scanner, userInput);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
    }

    static void getStation(Scanner scanner, UserInput userInput, boolean flag){
        SystemOutput.printMessage(SystemMessages.ADD_SECTION_STATION_MESSAGE);
        String stationName = userInput.getInput();
        try {
            station = validation.isExistStation(stationName);
            getOrder(scanner, userInput, flag);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
    }

    static void getStation(Scanner scanner, UserInput userInput){
        SystemOutput.printMessage(SystemMessages.DEL_SECTION_STATION_MESSAGE);
        String stationName = userInput.getInput();
        try {
            station = validation.isExistStation(stationName);
            getOrder(scanner, userInput);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
    }

    static void getOrder(Scanner scanner, UserInput userInput, boolean flag) {
        SystemOutput.printMessage(SystemMessages.SECTION_ORDER_MESSAGE);
        String input = userInput.getInput();
        try {
            validation.orderIsNumber(input);
            order = Integer.parseInt(input)-1;
            addSection(scanner);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
    }

    static void getOrder(Scanner scanner, UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.SECTION_ORDER_MESSAGE);
        String input = userInput.getInput();
        try {
            validation.orderIsNumber(input);
            order = Integer.parseInt(input)-1;
            deleteSection(scanner);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
    }
}
