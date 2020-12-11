package subway.controller;

import subway.menuType.FunctionType;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.DTO;
import subway.view.managementView.LineView;
import subway.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LineManagement {

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
            List<DTO> lineNames = LineRepository.lines().stream()
                    .map(Line::toDTO)
                    .collect(Collectors.toList());
            lineView.printAll(lineNames);
        } catch (RuntimeException e) {
            OutputView.showErrorMessage(e);
        }
    }
}
