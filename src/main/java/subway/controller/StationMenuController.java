package subway.controller;

import static subway.view.OutputView.DOT;
import static subway.view.OutputView.NEWLINE;

import java.util.Arrays;
import java.util.stream.Collectors;
import subway.exception.InvalidChoiceException;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class StationMenuController extends MenuController {

    public static final String TITLE = "역 관리 화면";

    public static final String INPUT_NAME_OF_STATION_TO_REGISTER = "등록할 역 이름을 입력하세요.";
    public static final String INPUT_NAME_OF_STATION_TO_UNREGISTER = "삭제할 역 이름을 입력하세요.";

    public static final String REGISTER_STATION_DETAIL = "역 등록";
    public static final String STATION_UNREGISTER_DETAIL = "역 삭제";
    public static final String LIST_STATIONS_DETAIL = "역 조회";
    public static final String LIST_OF_STATIONS = "역 목록";

    private StationMenuController() {
    }

    public static void main() {
        while (true) {
            printMenu();
            try {
                route(InputView.getInput());
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
                .orElseThrow(() -> {
                    throw new InvalidChoiceException(input);
                })
                .goToMenu();
    }

    private static void registerStation() {
        OutputView.printNotice(INPUT_NAME_OF_STATION_TO_REGISTER);
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
        while (true) {
            OutputView.printNotice(INPUT_NAME_OF_STATION_TO_UNREGISTER);
            try {
                // todo 구간에 등록된 역은 삭제불가
                StationService.removeStationByName(InputView.getInput());
                return;
            } catch (Exception e) {
                OutputView.printError(e);
            }
        }
    }

    private static void listStations() {
        OutputView.printNotice(LIST_OF_STATIONS);
        StationService.listAllStations();
    }

    private static void goBack() {
    }


    enum Menu {
        REGISTER_STATION(
                BUTTON_1,
                REGISTER_STATION_DETAIL,
                StationMenuController::registerStation),
        UNREGISTER_STATION(
                BUTTON_2,
                STATION_UNREGISTER_DETAIL,
                StationMenuController::unregisterStation),
        LIST_STATIONS(
                BUTTON_3,
                LIST_STATIONS_DETAIL,
                StationMenuController::listStations),
        GO_BACK(
                BUTTON_BACK,
                GO_BACK_DETAIL,
                StationMenuController::goBack);

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
