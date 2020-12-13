package subway.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import subway.exception.ExitSystemException;
import subway.exception.InvalidChoiceInputException;
import subway.view.InputView;
import subway.view.OutputView;

public class MainMenuController {

    public static final String TITLE = "메인 화면";
    public static final String NEWLINE = "\n";

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

    private static void printMenu() {
        OutputView.printInfo(TITLE + NEWLINE + Menu.getMenus());
    }

    private static void route(String input) {
        Arrays.stream(Menu.values())
                .filter(menu -> menu.button.equals(input))
                .findAny()
                .orElseThrow(InvalidChoiceInputException::new)
                .goToMenu();
    }

    private static void printSubwayMap() {
        // todo 서비스로 이동
    }

    private static void exitSystem() {
        throw new ExitSystemException();
    }

    enum Menu {
        MANAGE_STATION("1", "역 관리", StationMenuController::main),
        MANAGE_LINE("2", "노선 관리", LineMenuController::main),
        MANAGE_SECTION("3", "구간 관리", SectionMenuController::main),
        PRINT_SUBWAY_MAP("4", "지하철 노선도 출력", MainMenuController::printSubwayMap),
        EXIT_SYSTEM("Q", "종료", MainMenuController::exitSystem);

        public static final String DOT = ". ";

        private final String button;
        private final String detail;
        private final Runnable runnable;

        //1. 역 등록
        Menu(String button, String detail, Runnable runnable) {
            this.button = button;
            this.detail = detail;
            this.runnable = runnable;
        }

        public void goToMenu() {
            runnable.run();
        }

        public static String getMenus() {
            return Arrays.stream(Menu.values())
                    .map(Menu::toString)
                    .collect(Collectors.joining(NEWLINE));
        }

        @Override
        public String toString() {
            return button + DOT + detail;
        }
    }
}
