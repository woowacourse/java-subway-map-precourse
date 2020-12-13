package subway.Controller;

import subway.Exception.ExceptionHandler;
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
        ExceptionHandler.unselectableLine(selection, LINE_PATTERN);
        execute(selection);
    }

    private static void execute(String selection) {
        if (selection.equals(ADD)) {
            add();
        }
        if (selection.equals(TRAVERSE)) {
            traverse();
        }
    }

    private static void traverse() {
        OutputView.printLineList();
        LineRepository.lines().stream().forEach(line -> OutputView.printInfo(line.getName()));
    }

    private static void add() {
        String line = InputView.getAddLine();
        ExceptionHandler.lineNameShorterThanTwo(line);
        ExceptionHandler.lineContained(line);
        String upwardStation = InputView.getAddLineUpwardStation();
        String downwardStation = InputView.getAddLineDownwardStation();
        ExceptionHandler.stationSame(upwardStation, downwardStation);
        Line newLine = new Line(line);
        newLine.addStationByOrder(new Station(upwardStation), 0);
        newLine.addStationByOrder(new Station(downwardStation), 1);
        LineRepository.addLine(newLine);
        OutputView.printAddLineSuccess();
        MainController.run();
    }
}
