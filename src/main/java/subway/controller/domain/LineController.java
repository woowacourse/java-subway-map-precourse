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
        if (LineRepository.deleteLineByName(line)) {
            OutputView.printDeleteLineSuccess();
            return;
        }
        OutputView.printInfo("해당 역은 존재하지 않습니다.");
    }

    private static void traverse() {
        OutputView.printLineList(LineRepository.lines());
    }

    private static void add() {
        String line = InputView.getAddLine();
        LineExceptionHandler.lineNameShortThanMin(line);
        LineExceptionHandler.lineDuplicated(line);
        String from = InputView.getAddLineUpwardStation();
        String to = InputView.getAddLineDownwardStation();
        LineExceptionHandler.fromAndToStationDuplicated(from, to);

        Line newLine = new Line(line);
        Station fromStation = new Station(from);
        Station toStation = new Station(to);

        StationRepository.addStation(fromStation);
        StationRepository.addStation(toStation);

        newLine.addStationByOrder(fromStation, 0);
        newLine.addStationByOrder(toStation, 1);
        LineRepository.addLine(newLine);
        OutputView.printAddLineSuccess();
    }
}
