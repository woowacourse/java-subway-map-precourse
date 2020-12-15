package subway.controller;

import static subway.view.OutputView.DOT;
import static subway.view.OutputView.NEWLINE;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import subway.SubwayInitializer;
import subway.domain.LineRepository;
import subway.exception.ExitSystemException;
import subway.exception.InvalidChoiceException;
import subway.view.InputView;
import subway.view.OutputView;

public class MainMenuController extends MenuController {

    public static final String TITLE = "메인 화면";

    public static final String MANAGE_STATION_DETAIL = "역 관리";
    public static final String MANAGE_LINE_DETAIL = "노선 관리";
    public static final String MANAGE_SECTION_DETAIL = "구간 관리";
    public static final String PRINT_SUBWAY_MAP_DETAIL = "지하철 노선도 출력";
    public static final String EXIT_SYSTEM_DETAIL = "종료";

    private MainMenuController() {
    }

    public static void main(Scanner scanner) {
        init(scanner);

        while (true) {
            printMenu();
            try {
                route(InputView.getInput());
            } catch (ExitSystemException e) {
                OutputView.println(e.getMessage());
                return;
            } catch (Exception e) {
                OutputView.printError(e);
            }
        }
    }

    private static void init(Scanner scanner) {
        SubwayInitializer.init();
        InputView.registerScanner(scanner);
    }


    private static void printMenu() {
        OutputView.printMenu(TITLE, Menu.getMenus());
    }

    private static void route(String input) {
        Arrays.stream(Menu.values())
                .filter(menu -> menu.button.equals(input))
                .findAny()
                .orElseThrow(() -> {
                    throw new InvalidChoiceException(input);
                })
                .goToMenu();
    }

    private static void printSubwayMap() {
        OutputView.printSubwayMap(LineRepository.lines());
    }

    private static void exitSystem() {
        throw new ExitSystemException();
    }

    enum Menu {
        MANAGE_STATION(
                BUTTON_1,
                MANAGE_STATION_DETAIL,
                StationMenuController::main),
        MANAGE_LINE(
                BUTTON_2,
                MANAGE_LINE_DETAIL,
                LineMenuController::main),
        MANAGE_SECTION(
                BUTTON_3,
                MANAGE_SECTION_DETAIL,
                SectionMenuController::main),
        PRINT_SUBWAY_MAP(
                BUTTON_4,
                PRINT_SUBWAY_MAP_DETAIL,
                MainMenuController::printSubwayMap),
        EXIT_SYSTEM(
                BUTTON_QUIT,
                EXIT_SYSTEM_DETAIL,
                MainMenuController::exitSystem);

        private final String button;
        private final String detail;
        private final Runnable function;

        Menu(String button, String detail, Runnable function) {
            this.button = button;
            this.detail = detail;
            this.function = function;
        }

        public void goToMenu() {
            function.run();
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
