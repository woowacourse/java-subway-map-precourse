package subway.controller;

import static subway.view.OutputView.DOT;
import static subway.view.OutputView.NEWLINE;

import java.util.Arrays;
import java.util.stream.Collectors;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.AlreadyRegisteredLineNameException;
import subway.exception.InvalidChoiceException;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

public class LineMenuController extends MenuController {

    private static final String TITLE = "노선 관리 화면";

    public static final String LINE_IS_REGISTERED = "지하철 노선이 등록되었습니다.";
    public static final String LINE_IS_UNREGISTERED = "지하철 노선이 삭제되었습니다.";

    public static final String REGISTER_LINE_DETAIL = "노선 등록";
    public static final String UNREGISTER_LINE_DETAIL = "노선 삭제";
    public static final String LIST_LINES_DETAIL = "노선 조회";
    public static final String LIST_OF_LINES = "노선 목록";

    public static final String INPUT_NAME_OF_LINE_TO_REGISTER = "등록할 노선 이름을 입력하세요.";
    public static final String INPUT_NAME_OF_FIRST_STATION_TO_REGISTER_IN_LINE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String INPUT_NAME_OF_LAST_STATION_TO_REGISTER_IN_LINE = "등록할 노선의 하행 종점역 이름을 입력하세요.";

    public static final String INPUT_NAME_OF_LINE_TO_UNREGISTER = "삭제할 노선 이름을 입력하세요.";

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

    private static void route(String input) {
        Arrays.stream(LineMenuController.Menu.values())
                .filter(menu -> menu.button.equals(input))
                .findAny()
                .orElseThrow(() -> {
                    throw new InvalidChoiceException(input);
                })
                .goToMenu();
    }

    private static void printMenu() {
        OutputView.printMenu(TITLE, LineMenuController.Menu.getMenus());
    }

    private static void registerLine() {
        while (true) {
            try {
                getLineByInput();
                return;
            } catch (Exception e) {
                OutputView.printError(e);
            }
        }
    }

    private static void getLineByInput() {
        OutputView.printNotice(INPUT_NAME_OF_LINE_TO_REGISTER);
        String lineName = InputView.getInput();
        if (LineRepository.exists(lineName)) {
            throw new AlreadyRegisteredLineNameException(lineName);
        }

        OutputView.printNotice(INPUT_NAME_OF_FIRST_STATION_TO_REGISTER_IN_LINE);
        Station first = StationRepository.findByName(InputView.getInput());
        OutputView.printNotice(INPUT_NAME_OF_LAST_STATION_TO_REGISTER_IN_LINE);
        Station last = StationRepository.findByName(InputView.getInput());

        LineService.resisterLine(lineName, first, last);
        OutputView.printInfo(LINE_IS_REGISTERED);
    }

    private static void unregisterLine() {
        OutputView.printNotice(INPUT_NAME_OF_LINE_TO_UNREGISTER);
        while (true) {
            try {
                LineService.removeLineByName(InputView.getInput());
                OutputView.printInfo(LINE_IS_UNREGISTERED);
                return;
            } catch (Exception e) {
                OutputView.printError(e);
            }
        }
    }

    private static void listLines() {
        OutputView.printNotice(LIST_OF_LINES);
        LineService.listAllLines();
    }

    private static void goBack() {
    }


    enum Menu {
        REGISTER_LINE(
                BUTTON_1,
                REGISTER_LINE_DETAIL,
                LineMenuController::registerLine),
        UNREGISTER_LINE(
                BUTTON_2,
                UNREGISTER_LINE_DETAIL,
                LineMenuController::unregisterLine),
        LIST_LINES(
                BUTTON_3,
                LIST_LINES_DETAIL, LineMenuController::listLines),
        GO_BACK(
                BUTTON_BACK,
                GO_BACK_DETAIL,
                LineMenuController::goBack);

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
