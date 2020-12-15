package subway.controller.domain;

import subway.controller.MainController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.domain.LineExceptionHandler;
import subway.exception.input.LineInputExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {

    private static final String ADD = "1";
    private static final String DELETE = "2";
    private static final String TRAVERSE = "3";
    private static final String BACK = "B";

    public static void run() {
        OutputView.printLineView();
        select();
    }

    public static void select() {
        String selection = InputView.getSelectionView();
        LineInputExceptionHandler.unselectable(selection);
        if (selection.equals(BACK)) {
            MainController.run();
        }
        execute(selection);
    }

    private static void execute(String selection) {
        if (selection.equals(ADD)) {
            add();
        }
        if (selection.equals(TRAVERSE)) {
            traverse();
        }
        if (selection.equals(DELETE)) {
            delete();
        }
        MainController.run();
    }

    private static void delete() {
        String line = InputView.getDeleteLine();
        LineRepository.deleteLineByName(line);
        OutputView.printDeleteLineSuccess();
    }

    private static void traverse() {
        OutputView.printLineList(LineRepository.lines());
    }

    private static void add() {
        String line = InputView.getAddLine();
        String from = InputView.getAddLineUpwardStation();
        String to = InputView.getAddLineDownwardStation();
        addable(line, from, to);
        Station fromStation = addStation(from);
        Station toStation = addStation(to);
        Line addedLine = addLine(line);
        addSection(addedLine, fromStation, toStation);
        OutputView.printAddLineSuccess();
    }

    private static void addable(String line, String fromStation, String toStation) {
        LineExceptionHandler.lineNameShortThanMin(line);
        LineExceptionHandler.lineDuplicated(line);
        LineExceptionHandler.fromAndToStationDuplicated(fromStation, toStation);
    }

    private static Station addStation(String station) {
        Station newStation = new Station(station);
        StationRepository.addStation(newStation);
        return newStation;
    }

    private static Line addLine(String line) {
        Line newLine = new Line(line);
        LineRepository.addLine(newLine);
        return newLine;
    }

    private static void addSection(Line line, Station from, Station to) {
        line.addStationByOrder(from, 0);
        line.addStationByOrder(to, 0);
    }
}
