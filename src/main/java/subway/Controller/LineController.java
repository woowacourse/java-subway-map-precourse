package subway.Controller;

import subway.Exception.LineExceptionHandler;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {

    private static final String[] LINE_PATTERN = {"1", "2", "3", "B"};
    private static final String ADD = "1";
    private static final String DELETE = "2";
    private static final String TRAVERSE = "3";
    private static final String BACK = "B";

    public static void run() {
        OutputView.printLineView();
        select();
    }

    private static void select() {
        String selection = InputView.getSelectionView();
        if (selection.equals(BACK)) {
            MainController.run();
        }
        LineExceptionHandler.unselectable(selection, LINE_PATTERN);
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
        newLine.addStationByOrder(new Station(from), 0);
        newLine.addStationByOrder(new Station(to), 1);
        LineRepository.addLine(newLine);
        OutputView.printAddLineSuccess();
    }
}
