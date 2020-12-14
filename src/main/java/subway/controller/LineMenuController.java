package subway.controller;

import static subway.view.OutputView.DOT;
import static subway.view.OutputView.NEWLINE;

import java.util.Arrays;
import java.util.stream.Collectors;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.AlreadyRegisteredLineNameException;
import subway.exception.GoBackToPrevControllerException;
import subway.exception.InvalidChoiceException;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

public class LineMenuController {

    private static final String TITLE = "노선 관리 화면";

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
        OutputView.printNotice("등록할 노선 이름을 입력하세요.");
        String lineName = InputView.getInput();
        if (LineRepository.exists(lineName)) {
            throw new AlreadyRegisteredLineNameException(lineName);
        }

        OutputView.printNotice("등록할 노선의 상행 종점역 이름을 입력하세요.");
        Station first = StationRepository.findByName(InputView.getInput());
        OutputView.printNotice("등록할 노선의 하행 종점역 이름을 입력하세요.");
        Station last = StationRepository.findByName(InputView.getInput());

        LineService.resisterLine(lineName, first, last);
    }

    private static void unregisterLine() {
        OutputView.printNotice("삭제할 노선 이름을 입력하세요.");
        while (true) {
            try {
                LineService.removeLineByName(InputView.getInput());
                return;
            } catch (Exception e) {
                OutputView.printError(e);
            }
        }
    }

    private static void listLines() {
        LineService.listAllLines();
    }

    private static void goBack() {
    }


    enum Menu {
        REGISTER_LINE("1", "노선 등록", LineMenuController::registerLine),
        UNREGISTER_LINE("2", "노선 삭제", LineMenuController::unregisterLine),
        LIST_LINES("3", "노선 조회", LineMenuController::listLines),
        GO_BACK("B", "돌아가기", LineMenuController::goBack);

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
            return Arrays.stream(LineMenuController.Menu.values())
                    .map(LineMenuController.Menu::toString)
                    .collect(Collectors.joining(NEWLINE));
        }

        @Override
        public String toString() {
            return button + DOT + detail;
        }
    }
}
