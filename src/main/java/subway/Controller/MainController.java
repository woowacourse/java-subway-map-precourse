package subway.Controller;

import subway.Exception.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    private static final String[] MAIN_PATTERN = {"1", "2", "3", "4"};
    private static final String STAION = "1";
    private static final String LINE = "2";
    private static final String SECTION = "3";
    private static final String MAP = "4";

    public static void run() {
        OutputView.printMainView();
        select();
    }

    public static void select() {
        String selection = InputView.getSelectionView();
        if (selection.equals("Q")) {
            return;
        }
        ExceptionHandler.unselectableMain(selection, MAIN_PATTERN);
        execute(selection);
    }

    private static void execute(String selection) {
        if (selection.equals(STAION)) {
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
