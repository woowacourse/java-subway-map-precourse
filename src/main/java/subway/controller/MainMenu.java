package subway.controller;

import subway.utils.Message;
import subway.view.OutputView;

public class MainMenu implements Message{

    private static final String STATION_MANAGEMENT = "1";
    private static final String LINE_MANAGEMENT = "2";
    private static final String SECTION_MANAGEMENT = "3";
    private static final String PRINT_WHOLE_SECTION = "4";


    public static void request(String selection) {
        if (selection.equals(STATION_MANAGEMENT)) {
            SubwayManager.manageStation();
            return;
        }
        if (selection.equals(LINE_MANAGEMENT)) {
            SubwayManager.manageLine();
            return;
        }
        if (selection.equals(SECTION_MANAGEMENT)) {
            SubwayManager.manageSection();
            return;
        }
        if (selection.equals(PRINT_WHOLE_SECTION)) {
            OutputView.printWholeSection();
            return;
        }
        OutputView.printError(ERROR_INVALID_SELECTION);
    }
}
