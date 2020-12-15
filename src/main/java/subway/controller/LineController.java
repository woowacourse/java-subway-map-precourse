package subway.controller;


import static subway.views.LineControlView.showLineDeleteView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.views.ErrorMessage;
import subway.views.LineControlView;

public class LineController {

    public static void manageLine(Scanner scanner) {
        LineControlView.showLineControlView(scanner);
    }

    public static void addStationInLine(String userInput, String startStation, String endStation) {
        Line newLine = new Line(userInput);
        newLine.addStationListInLine(new ArrayList<>(Arrays.asList(startStation, endStation)));
        LineRepository.addLine(newLine);
    }

    public static void deleteLine(String userInput, Scanner scanner) {
        if (!ErrorValidator.checkSameLineName(userInput)) {
            ErrorMessage.showLineDeleteError();
            showLineDeleteView(scanner);
        }
        LineRepository.deleteLineByName(userInput);
    }
}
