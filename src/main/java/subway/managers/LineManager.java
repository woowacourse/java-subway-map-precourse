package subway.managers;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.views.SystemMessages;
import subway.views.SystemOutput;
import subway.views.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineManager {
    private static Line line;

    public static void runLineManager(Scanner scanner, UserInput userInput) {
        SystemOutput.printLineMessage();
        String input = userInput.getStationLineInput();

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
        // 없을 때 추가작업
        Station upwardStation = StationRepository.searchInStations(upward);
        line.addSection(upwardStation);
    }

    static void addDownwardStation(UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_DOWNWARD_STATION_MESSAGE);
        String downward = userInput.getNameInput();
        // 없을 때 추가 작업
        Station downwardStation = StationRepository.searchInStations(downward);
        line.addSection(downwardStation);
    }

    static void deleteLine(UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.DEL_STATION_MESSAGE);
        String name = userInput.getNameInput();
        // 있는지 없는지 확인
        LineRepository.deleteLineByName(name);
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
