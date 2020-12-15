package subway.controller;

import subway.utils.Util;
import subway.view.OutputView;

import java.util.Scanner;

public class Controller {
    private static final int START = 1;
    private static final int END = 4;
    private static final int ERROR = -1;
    private static final int STATION_MAINTAIN = 1;
    private static final int LINE_MAINTAIN = 2;
    private static final int SECTION_MAINTAIN = 3;
    private static final int SUBWAY_MAP = 4;

    private final Scanner scanner;

    public Controller(Scanner scanner) {
        this.scanner = scanner;
        mainPage();
    }


    public void mainPage() {
        OutputView.mainPage();
        control();
    }

    private void control() {
        OutputView.writeOperation();
        int operationNumber = Util.operationNumber(scanner.next(), START, END);
        movePage(operationNumber, scanner);
    }

    private void movePage(int operationNumber, Scanner scanner) {
        if (operationNumber == ERROR) {
            control();
        }
        if (operationNumber == STATION_MAINTAIN) {
            new StationMaintain(scanner);
        }
        if (operationNumber == LINE_MAINTAIN) {
            new LineMaintain(scanner);
        }
        if (operationNumber == SECTION_MAINTAIN) {
            new SectionMaintain(scanner);
        }
        if (operationNumber == SUBWAY_MAP) {
            new MapMaintain(scanner);
        }
    }
}
