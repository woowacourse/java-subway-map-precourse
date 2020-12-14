package subway.Controller;

import subway.Exception.ExceptionHandler;
import subway.Exception.SectionExceptionHandler;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {

    private static final String[] SECTION_PATTERN = {"1", "2", "B"};
    private static final String ADD = "1";
    private static final String DELETE = "2";
    private static final String BACK = "B";

    public static void run() {
        OutputView.printStationLineView();
        select();
    }

    public static void select() {
        String selection = InputView.getSelectionView();
        if (selection.equals(BACK)) {
            MainController.run();
        }
        ExceptionHandler.unselectableStation(selection, SECTION_PATTERN);
        execute(selection);
    }

    private static void execute(String selection) {
        if (selection.equals(ADD)) {
            add();
        }
        if (selection.equals(DELETE)) {
            delete();
        }
        MainController.run();

    }

    private static void add() {
        String line = InputView.getAddStationToLine();
        ExceptionHandler.notLineContained(line); //
        String station = InputView.getAddStation();
        ExceptionHandler.stationShouldNotBeInLineForAddingToSection(line, station);
        String order = InputView.getAddStationOrder();
        ExceptionHandler.positiveInt(order);
        ExceptionHandler.lineOverflow(line, order);
        Line targetLine = LineRepository.findByLineName(line);
        targetLine.addStationByOrder(new Station(station), Integer.parseInt(order));
        OutputView.printAddStationToLineSuccess();
    }

    private static void delete() {
        String line = InputView.getDeleteStationFromLine();
        SectionExceptionHandler.noLine(line);
        SectionExceptionHandler.stationInLineLessThanMinLength(line);
        String station = InputView.getDeleteStation();
        SectionExceptionHandler.noStationInLine(line, station);
        LineRepository.deleteStationFromLineByName(line, station);
        OutputView.printDeleteStationFromLineSuccess();
    }
}
