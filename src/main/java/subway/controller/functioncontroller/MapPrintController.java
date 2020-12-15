package subway.controller.functioncontroller;

import subway.view.mapprintoutput.MapPrintInfoView;
import subway.view.mapprintoutput.MapPrintOutputView;

public class MapPrintController extends FunctionController {
    public static void start() {
        runMapPrintController();
    }

    private static void runMapPrintController() {
        MapPrintOutputView.printMapList();
        MapPrintInfoView.printMap();
    }
}
