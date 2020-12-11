package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LineManagement {
    private static final String REGISTER = "1";
    private static final String DELETE = "2";
    private static final String PRINT = "3";
    private static final String BACK = "B";

    private static String menu;

    public static void run() {
        do {
            OutputView.showLineManagementView();
            menu = InputView.getLineMenuSelection();
            runSelectedMenuFunction();
        } while(!menu.equals(BACK));
    }

    private static void runSelectedMenuFunction() {
        if (menu.equals(REGISTER)) {
            registerLine();
        }
        if (menu.equals(DELETE)) {
            deleteLine();
        }
        if (menu.equals(PRINT)) {
            printAllLines();
        }
    }

    private static void registerLine() {
        try {
            Line line = new Line(InputView.getLineNameToRegister());
            Station upLineEndStation = StationRepository.searchStationByName(InputView.getUplineStationName());
            Station downLineEndStation = StationRepository.searchStationByName(InputView.getDownlineStationName());
            line.addStation(upLineEndStation);
            line.addStation(downLineEndStation);
            LineRepository.addLine(line);
            OutputView.printLineRegisterDone();
        } catch (Exception e) {
            OutputView.showErrorMessage(e);
        }
    }

    private static void deleteLine() {
        try {
            LineRepository.deleteLineByName(InputView.getLineNameToDelete());
            OutputView.printLineDeleteDone();
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
        }
    }

    private static void printAllLines() {
        try {
            List<String> lineNames = LineRepository.lines().stream()
                    .map(Line::getName)
                    .collect(Collectors.toList());
            OutputView.printLines(lineNames);
        } catch (RuntimeException e) {
            OutputView.showErrorMessage(e);
        }
    }
}
