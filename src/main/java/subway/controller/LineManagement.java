package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineManagement {
    private static final String REGISTER = "1";
    private static final String DELETE = "2";
    private static final String PRINT = "3";
    private static final String BACK = "B";

    private static String menu;

    public static void run() {
        do {

            runSelectedMenuFunction();
        } while(!menu.equals(BACK));
    }

    private static void runSelectedMenuFunction() {

    }
}
