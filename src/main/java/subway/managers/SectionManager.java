package subway.managers;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.views.SystemMessages;
import subway.views.SystemOutput;
import subway.views.UserInput;

import java.util.Scanner;

public class SectionManager {
    public static void runSectionManager(Scanner scanner, UserInput userInput) {
        SystemOutput.printSectionMessage();
        String input = userInput.getSectionInput();

        if (input.equals("1")) {
            addSection(userInput);
        }
        if (input.equals("2")) {
            deleteSection(userInput);
        }
        if (input.equals("B")) {
            SubwayManager.runManager(scanner);
        }
    }

    static void addSection(UserInput userInput) {
        Line line = getLine(userInput);
        Station station = getStation(userInput);
        int order = getOrder(userInput);
        line.addSection(order, station);
        SystemOutput.printInfo(SystemMessages.ADD_SECTION_COMPLETE_MESSAGE);
    }

    static void deleteSection(UserInput userInput) {
        Line line = getLine(userInput);
        Station station = getStation(userInput);
        int order = getOrder(userInput);
        line.deleteSection(order);
        SystemOutput.printInfo(SystemMessages.DEL_SECTION_COMPLETE_MESSAGE);
    }

    static Line getLine(UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_SECTION_LINE_MESSAGE);
        String lineName = userInput.getNameInput();
        return LineRepository.searchLineByName(lineName);
    }

    static Station getStation(UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_SECTION_STATION_MESSAGE);
        String stationName = userInput.getNameInput();
        return StationRepository.searchStationByName(stationName);
    }

    static int getOrder(UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_SECTION_ORDER_MESSAGE);
        String input = userInput.getNameInput();  // 이름 나중에 바꿀 것
        // 숫자인지 검증 필요
        return Integer.parseInt(input);
    }


}
