package subway.managers;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.exceptions.SubwayException;
import subway.exceptions.Validation;
import subway.views.SystemMessages;
import subway.views.SystemOutput;
import subway.views.UserInput;

import java.util.List;
import java.util.Scanner;

public class SubwayManager {
    private static UserInput userInput;

    public SubwayManager(Scanner scanner) {
        runManager(scanner);
    }

    public static void runManager(Scanner scanner) {
        userInput = new UserInput(scanner);
        SystemOutput.printMainMessage();
        String input = userInput.getInput();
        mainOption(scanner, userInput, input);
    }

    private static void mainOption(Scanner scanner, UserInput userInput, String input) {
        try {
            new Validation().mainOptionValidation(input);
        } catch (SubwayException e) {
            runManager(scanner);
        };
        if (input.equals("1")) {
            StationManager.runStationManager(scanner, userInput);
            runManager(scanner);
        }
        if (input.equals("2")) {
            LineManager.runLineManager(scanner, userInput);
            runManager(scanner);
        }
        if (input.equals("3")) {
            SectionManager.runSectionManager(scanner, userInput);
            runManager(scanner);
        }
        if (input.equals("4")) {
            subwayMapManager();
            runManager(scanner);
        }
        if (input.equals("Q")) {
            return;
        }
    }

    private static void subwayMapManager() {
        SystemOutput.printMessage(SystemMessages.SUBWAY_MAP_MESSAGE);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            SystemOutput.printInfo(line.getName());
            SystemOutput.printInfo(SystemMessages.DIVIDE);
            List<Station> stations = line.getSection();
            for (Station station : stations) {
                SystemOutput.printInfo(station.getName());
            }
            SystemOutput.printMessage("");
        }
    }
}
