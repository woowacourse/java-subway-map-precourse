package subway.managers;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.exceptions.SubwayException;
import subway.exceptions.Validation;
import subway.views.SystemMessages;
import subway.views.SystemOutput;
import subway.views.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineManager {
    private static Validation validation = new Validation();

    public static void runLineManager(Scanner scanner, UserInput userInput) {
        SystemOutput.printLineMessage();
        String input = userInput.getInput();
        try {
            validation.stationLineOptionValidation(input);
        } catch (SubwayException e) {
            runLineManager(scanner, userInput);
        }
        if (input.equals("1")) {
            addLine(scanner, userInput);
        }
        if (input.equals("2")) {
            deleteLine(scanner, userInput);
        }
        if (input.equals("3")) {
            showLineList();
        }
        if (input.equals("B")) {
            SubwayManager.runManager(scanner);
        }
    }

    static void addLine(Scanner scanner, UserInput userInput) {
        String name = newLine(userInput);
        Station upwardStation = addUpwardStation(scanner, userInput);
        Station downwardStation = addDownwardStation(scanner, userInput);
        Line line = new Line(name, upwardStation, downwardStation);
        LineRepository.addLine(line);
        SystemOutput.printInfo(SystemMessages.ADD_STATION_COMPLETE_MESSAGE);
    }

    static String newLine(UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_LINE_MESSAGE);
        String lineName = userInput.getInput();
        try {
            validation.lineNameValidation(lineName);
            validation.lineDuplication(lineName);
        } catch (SubwayException e) {
            newLine(userInput);
        }
        return lineName;
    }

    static Station addUpwardStation(Scanner scanner, UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_UPWARD_STATION_MESSAGE);
        String upward = userInput.getInput();
        try {
            Station upwardStation = validation.isExistStation(upward);
            return upwardStation;
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
        return null;
    }

    static Station addDownwardStation(Scanner scanner, UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_DOWNWARD_STATION_MESSAGE);
        String downward = userInput.getInput();
        try {
            Station downwardStation = validation.isExistStation(downward);
            return downwardStation;
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
        return null;
    }

    static void deleteLine(Scanner scanner, UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.DEL_STATION_MESSAGE);
        String name = userInput.getInput();
        try {
            validation.isExistLine(name);
            LineRepository.deleteLineByName(name);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
        SystemOutput.printInfo(SystemMessages.DEL_STATION_COMPLETE_MESSAGE);
    }

    static void showLineList() {
        SystemOutput.printMessage(SystemMessages.LINE_LIST_MESSAGE);
        List<Line> lines = LineRepository.getLines();
        List<String> names = new ArrayList();
        for (Line line : lines) {
            names.add(line.getName());
        }
        String[] lineList = new String[names.size()];
        SystemOutput.printList(names.toArray(lineList));
    }
}
