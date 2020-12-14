package subway.controller;

import static subway.view.OutputView.DOT;
import static subway.view.OutputView.NEWLINE;

import java.util.Arrays;
import java.util.stream.Collectors;
import subway.exception.GoBackToPrevControllerException;
import subway.exception.InvalidChoiceException;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionMenuController {

    private static final String TITLE = "구간 관리 화면";

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
        OutputView.printMenu(TITLE, LineMenuController.Menu.getMenus());

    }

    private static void registerSection() {

    }

    private static void unregisterSection() {
    }

    private static void goBack() {
    }


    enum Menu {
        REGISTER_SECTION("1", "구간 등록", SectionMenuController::registerSection),
        UNREGISTER_SECTION("2", "구간 삭제", SectionMenuController::unregisterSection),
        GO_BACK("B", "돌아가기", SectionMenuController::goBack);
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
            return Arrays.stream(SectionMenuController.Menu.values())
                    .map(SectionMenuController.Menu::toString)
                    .collect(Collectors.joining(NEWLINE));
        }

        @Override
        public String toString() {
            return button + DOT + detail;
        }

    }

}
