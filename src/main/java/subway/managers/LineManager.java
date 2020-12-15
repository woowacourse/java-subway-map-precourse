package subway.managers;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exceptions.SubwayException;
import subway.exceptions.Validation;
import subway.views.SystemMessages;
import subway.views.SystemOutput;
import subway.views.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineManager {
    private static Line line;
    private static Validation validation = new Validation();

    public static void runLineManager(Scanner scanner, UserInput userInput) {
        SystemOutput.printLineMessage();
        String input = userInput.getStationLineInput();
        try {
            validation.stationLineOptionValidation(input);
        } catch (SubwayException e) {
            runLineManager(scanner, userInput);
        }
        if (input.equals("1")) {
            addLine(userInput);
        }
        if (input.equals("2")) {
            deleteLine(userInput);
        }
        if (input.equals("3")) {
            showLineList();
        }
        if (input.equals("B")) {
            SubwayManager.runManager(scanner);
        }
    }

    static void addLine(UserInput userInput) {
        newLine(userInput);
        addUpwardStation(userInput);
        addDownwardStation(userInput);
        SystemOutput.printInfo(SystemMessages.ADD_STATION_COMPLETE_MESSAGE);
    }

    static void newLine(UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_LINE_MESSAGE);
        String lineName = userInput.getNameInput();
        line = new Line(lineName);
    }

    static void addUpwardStation(UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_UPWARD_STATION_MESSAGE);
        String upward = userInput.getNameInput();
        try {
            Station upwardStation = validation.isExistStation(upward);
            line.addSection(upwardStation);
        } catch (SubwayException ignored) {}
    }

    static void addDownwardStation(UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_DOWNWARD_STATION_MESSAGE);
        String downward = userInput.getNameInput();
        try {
            Station downwardStation = validation.isExistStation(downward);
            line.addSection(downwardStation);
        } catch (SubwayException ignored) {}
    }

    static void deleteLine(UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.DEL_STATION_MESSAGE);
        String name = userInput.getNameInput();
        try {
            validation.isExistLine(name);
            LineRepository.deleteLineByName(name);
        } catch (SubwayException ignored) {}
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
