package subway.controller;

import subway.controller.domain.LineController;
import subway.controller.domain.MapController;
import subway.controller.domain.SectionController;
import subway.controller.domain.StationController;
import subway.exception.input.MainInputExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    private static final String STATION = "1";
    private static final String LINE = "2";
    private static final String SECTION = "3";
    private static final String MAP = "4";
    private static final String STOP = "Q";

    public static void run() {
        OutputView.printMainView();
        select();
    }

    public static void select() {
        String selection = InputView.getSelectionView();
        MainInputExceptionHandler.unselectable(selection);
        if (selection.equals(STOP)) {
            return;
        }
        execute(selection);
    }

    private static void execute(String selection) {
        if (selection.equals(STATION)) {
            StationController.run();
        }
        if (selection.equals(LINE)) {
            LineController.run();
        }
        if (selection.equals(SECTION)) {
            SectionController.run();
        }
        if (selection.equals(MAP)) {
            MapController.run();
        }
    }
}
