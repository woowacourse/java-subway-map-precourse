package subway.controller.domain;

import subway.controller.MainController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.exception.domain.SectionExceptionHandler;
import subway.exception.domain.StationExceptionHandler;
import subway.exception.input.SectionInputExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {

    private static final String ADD = "1";
    private static final String DELETE = "2";
    private static final String BACK = "B";

    public static void run() {
        OutputView.printStationLineView();
        select();
    }

    public static void select() {
        String selection = InputView.getSelectionView();
        SectionInputExceptionHandler.unselectable(selection);
        if (selection.equals(BACK)) {
            MainController.run();
        }
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
        String station = InputView.getAddStation();
        String order = InputView.getAddStationOrder();
        addable(line, station, order);
        Line targetLine = LineRepository.findByLineName(line);
        targetLine.addStationByOrder(new Station(station), Integer.parseInt(order));
        OutputView.printAddStationToLineSuccess();
    }

    private static void addable(String line, String station, String order) {
        StationExceptionHandler.stationNameShorterThanTwo(station);
        SectionExceptionHandler.notLineContained(line);
        SectionExceptionHandler.stationShouldNotBeInLineForAddingToSection(line, station);
        SectionExceptionHandler.positiveInt(order);
        SectionExceptionHandler.lineOverflow(line, order);
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
