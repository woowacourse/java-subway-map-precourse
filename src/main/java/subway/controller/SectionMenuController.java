package subway.controller;

import static subway.view.OutputView.DOT;
import static subway.view.OutputView.NEWLINE;

import java.util.Arrays;
import java.util.stream.Collectors;
import subway.exception.InvalidChoiceException;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionMenuController extends MenuController {

    private static final String TITLE = "구간 관리 화면";

    public static final String REGISTER_SECTION_DETAIL = "구간 등록";
    public static final String UNREGISTER_SECTION_DETAIL = "구간 삭제";

    public static final String INPUT_LINE_OF_SECTION_TO_REGISTER = "등록할 구간의 노선을 입력하세요.";
    public static final String INPUT_STATION_OF_SECTION_TO_REGISTER = "등록할 구간의 역을 입력하세요.";
    public static final String INPUT_INDEX_OF_SECTION_TO_REGISTER = "등록할 구간의 순서를 입력하세요.";
    public static final String SECTION_IS_REGISTERED = "구간이 등록되었습니다.";

    public static final String INPUT_LINE_OF_SECTION_TO_UNREGISTER = "삭제할 구간의 노선을 입력하세요.";
    public static final String INPUT_STATION_OF_SECTION_TO_UNREGISTER = "삭제할 구간의 역을 입력하세요.";
    public static final String SECTION_IS_UNREGISTERED = "구간이 삭제되었습니다.";

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
        Arrays.stream(SectionMenuController.Menu.values())
                .filter(menu -> menu.button.equals(input))
                .findAny()
                .orElseThrow(() -> {
                    throw new InvalidChoiceException(input);
                })
                .goToMenu();
    }

    private static void printMenu() {
        OutputView.printMenu(TITLE, Menu.getMenus());
    }

    private static void registerSection() {
        OutputView.printNotice(INPUT_LINE_OF_SECTION_TO_REGISTER);
        String lineName = InputView.getInput();

        OutputView.printNotice(INPUT_STATION_OF_SECTION_TO_REGISTER);
        String stationName = InputView.getInput();

        OutputView.printNotice(INPUT_INDEX_OF_SECTION_TO_REGISTER);
        Integer index = Integer.parseInt(InputView.getInput());

        LineService.insertSection(lineName, stationName, index);
        OutputView.printInfo(SECTION_IS_REGISTERED);
    }

    private static void unregisterSection() {
        OutputView.printNotice(INPUT_LINE_OF_SECTION_TO_UNREGISTER);
        String lineName = InputView.getInput();

        OutputView.printNotice(INPUT_STATION_OF_SECTION_TO_UNREGISTER);
        String stationName = InputView.getInput();

        LineService.removeSection(lineName, stationName);
        OutputView.printInfo(SECTION_IS_UNREGISTERED);
    }

    private static void goBack() {
    }


    enum Menu {
        REGISTER_SECTION(
                BUTTON_1,
                REGISTER_SECTION_DETAIL,
                SectionMenuController::registerSection),
        UNREGISTER_SECTION(
                BUTTON_2,
                UNREGISTER_SECTION_DETAIL,
                SectionMenuController::unregisterSection),
        GO_BACK(
                BUTTON_BACK,
                GO_BACK_DETAIL,
                SectionMenuController::goBack);

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
