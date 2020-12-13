package subway.controller;

import static subway.view.OutputView.DOT;
import static subway.view.OutputView.NEWLINE;

import java.util.Arrays;
import java.util.stream.Collectors;
import subway.exception.GoBackToPrevControllerException;
import subway.exception.InvalidChoiceInputException;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class StationMenuController {

    public static final String TITLE = "역 관리 화면";

    private StationMenuController() {
    }

    public static void main() {
        while (true) {
            printMenu();
            try {
                route(InputView.getInput());
            } catch (GoBackToPrevControllerException e) {
                return;
            } catch (Exception e) {
                OutputView.printError(e);
                continue;
            }
            return;
        }
    }

    private static void printMenu() {
        OutputView.printMenu(TITLE, Menu.getMenus());
    }

    private static void route(String input) {
        Arrays.stream(Menu.values())
                .filter(menu -> menu.button.equals(input))
                .findAny()
                .orElseThrow(() -> {throw new InvalidChoiceInputException(input);})
                .goToMenu();
    }

    private static void registerStation() {
        OutputView.printNotice("등록할 역 이름을 입력하세요.");
        while (true) {
            try {
                StationService.resisterStationByName(InputView.getInput());
                return;
            } catch (Exception e) {
                OutputView.printError(e);
            }
        }
    }

    private static void unregisterStation() {
        OutputView.printNotice("삭제할 역 이름을 입력하세요.");
        while (true) {
            try {
                StationService.removeStationByName(InputView.getInput());
                return;
            } catch (Exception e) {
                OutputView.printError(e);
            }
        }
    }

    private static void listStations() {
        OutputView.print(NEWLINE);
        OutputView.printNotice("역 목록");
        StationService.listAllStations();
    }

    private static void goBack() {
        throw new GoBackToPrevControllerException();
    }


    enum Menu {
        REGISTER_STATION("1", "역 등록", StationMenuController::registerStation),
        UNREGISTER_STATION("2", "역 삭제", StationMenuController::unregisterStation),
        LIST_STATIONS("3", "역 조회", StationMenuController::listStations),
        GO_BACK("B", "돌아가기", StationMenuController::goBack);

        private final String button;
        private final String detail;
        private final Runnable runnable;

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
