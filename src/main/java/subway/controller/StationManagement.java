package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class StationManagement {
    private static final String CREATE = "1";
    private static final String DELETE = "2";
    private static final String DISPLAY = "3";
    private static final String BACK = "B";

    private static String menu;

    public static void run() {
        do {
            OutputView.showStationManagementView();
            menu = InputView.getStationMenuSelection();
        } while(!menu.equals(BACK));
    }
}
