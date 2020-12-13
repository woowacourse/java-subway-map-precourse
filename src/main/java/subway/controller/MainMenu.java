package subway.controller;

import subway.controller.SubwayManager;
import subway.view.OutputView;

public class MainMenu {

    private static final String STATION_MANAGEMENT = "1";
    private static final String LINE_MANAGEMENT = "2";
    private static final String SECTION_MANAGEMENT = "3";
    private static final String PRINT_WHOLE_SECTION = "4";


    public static void request(String selection) {
        if (selection.equals(STATION_MANAGEMENT)) {
            SubwayManager.manageStation();
        }
        if (selection.equals(LINE_MANAGEMENT)) {
            SubwayManager.manageLine();
        }
        if (selection.equals(SECTION_MANAGEMENT)) {
            SubwayManager.manageSection();
        }
        if (selection.equals(PRINT_WHOLE_SECTION)) {
            OutputView.printWholeSection();
        }
    }
}
