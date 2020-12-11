package subway.controller;

import subway.MenuType.FunctionType;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.managementView.LineView;
import subway.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LineManagement {
    private static final String CREATE = "1";
    private static final String DELETE = "2";
    private static final String READ = "3";
    private static final String ESCAPE = "B";

    private static LineView lineView = LineView.getInstance();
    private static FunctionType menu;

    public static void run() {
        do {
            lineView.showMenu();
            menu = lineView.getFunctionSelection();
            runSelectedMenuFunction();
        } while(!menu.equals(FunctionType.ESCAPE));
    }

    private static void runSelectedMenuFunction() {
        if (menu.equals(FunctionType.CREATE)) {
            registerLine();
        }
        if (menu.equals(FunctionType.DELETE)) {
            deleteLine();
        }
        if (menu.equals(FunctionType.READ)) {
            printAllLines();
        }
    }

    private static void registerLine() {
        try {
            Line line = new Line(lineView.getNameToCreate());
            Station upLineEndStation = StationRepository.searchByName(lineView.getUplineStationName());
            Station downLineEndStation = StationRepository.searchByName(lineView.getDownlineStationName());
            line.addStation(upLineEndStation);
            line.addStation(downLineEndStation);
            LineRepository.addLine(line);
            lineView.printRegisterDone();
        } catch (Exception e) {
            OutputView.showErrorMessage(e);
        }
    }

    private static void deleteLine() {
        try {
            LineRepository.deleteLineByName(lineView.getNameToCreate());
            lineView.printDeleteDone();
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
        }
    }

    private static void printAllLines() {
        try {
            List<String> lineNames = LineRepository.lines().stream()
                    .map(Line::getName)
                    .collect(Collectors.toList());
            lineView.printAll(lineNames);
        } catch (RuntimeException e) {
            OutputView.showErrorMessage(e);
        }
    }
}
