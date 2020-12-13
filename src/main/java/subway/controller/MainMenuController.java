package subway.controller;

import java.util.Arrays;
import subway.exception.ExitSystemException;
import subway.exception.InvalidChoiceInputException;
import subway.view.InputView;
import subway.view.OutputView;

public class MainMenuController {

    public static final String TITLE = "메인 화면";
    public static final String MANAGE_STATION = "1";
    public static final String MANAGE_LINE = "2";
    public static final String MANAGE_SECTION = "3";
    public static final String PRINT_SUBWAY_MAP = "4";
    public static final String EXIT_SYSTEM = "Q";

    public static final String DOT = ". ";

    enum Menu {
        MANAGE_STATION("1", "역 관리", StationMenuController::main),
        MANAGE_LINE("2", "노선 관리", LineMenuController::main),
        MANAGE_SECTION("3", "구간 관리", SectionMenuController::main),
        PRINT_SUBWAY_MAP("4", "지하철 노선도 출력", MainMenuController::printSubwayMap),
        EXIT_SYSTEM("Q", "종료", MainMenuController::exitSystem);

        private final String button;
        private final String detail;
        private final Runnable runnable;

        //1. 역 등록
        Menu(String button, String detail, Runnable runnable) {
            this.button = button;
            this.detail = detail;
            this.runnable = runnable;
        }

        @Override
        public String toString() {
            return button + DOT + detail;
        }
    }


    private MainMenuController() {
    }

    public static void main() {
        printMenu();
        while (true) {
            try {
                route(InputView.getInput());
            } catch (ExitSystemException e) {
                OutputView.printError(e);
                return;
            }
        }
    }

    private static void printSubwayMap() {
        // 지하철 노선도 출력
    }

    private static void exitSystem() {
        throw new ExitSystemException();
    }

    private static void printMenu() {
        OutputView.printInfo(TITLE);
        Arrays.stream(Menu.values()).forEach(menu -> OutputView.print(menu.toString()));
    }

    private static void route(String input) {
        Arrays.stream(Menu.values())
                .filter(menu -> menu.button.equals(input))
                .findAny()
                .orElseThrow(InvalidChoiceInputException::new)
                .runnable.run();

//        if (MANAGE_STATION.equals(input)) {
//            StationMenuController.main();
//        }
//        if (MANAGE_LINE.equals(input)) {
//            LineMenuController.main();
//        }
//        if (MANAGE_SECTION.equals(input)) {
//            SectionMenuController.main();
//        }
//        if (PRINT_SUBWAY_MAP.equals(input)) {
//            printSubwayMap();
//        }
//        if (EXIT_SYSTEM.equals(input)) {
//            exitSystem();
//        }
    }
}
