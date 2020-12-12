package subway.controller;

import subway.menuType.FunctionType;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.DTO;
import subway.view.menuView.LineView;
import subway.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LineManagement {

    private static LineView lineView = LineView.getInstance();
    private static FunctionType menu;

    public static void run() {
        do {
            try {
                lineView.printMenu();
                menu = lineView.getFunctionSelection();
                runSelectedMenuFunction();
            } catch (RuntimeException e) {
                OutputView.printErrorMessage(e);
            }
        } while (!menu.equals(FunctionType.ESCAPE));
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
        Line line = new Line(lineView.getNameToCreate());

        Station upLineEndStation = StationRepository.searchByName(lineView.getUplineStationName());
        line.addStation(upLineEndStation);
        Station downLineEndStation = StationRepository.searchByName(lineView.getDownlineStationName());
        line.addStation(downLineEndStation);

        LineRepository.addLine(line);
        lineView.printCreateDone();
    }

    private static void deleteLine() {
        LineRepository.deleteLineByName(lineView.getNameToDelete());
        lineView.printDeleteDone();
    }

    private static void printAllLines() {
        List<DTO> lineNames = LineRepository.lines().stream()
                .map(Line::toDTO)
                .collect(Collectors.toList());

        lineView.printAll(lineNames);
    }
}
