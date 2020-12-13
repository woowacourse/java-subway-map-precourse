package subway.view.page;

import subway.controller.LineController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class LineMenu {
    private static LineController lineController;

    private LineMenu() {
    }

    public static void run(Scanner scanner) {
        lineController = LineController.getInstance(scanner);
        printMenu();
        Menu selected = getMenuSelection(scanner);
        selected.execute();
    }

    public static void printMenu() {
        Arrays.stream(Menu.values())
                .map(Menu -> Menu.getMenuName() + "\n")
                .forEach(OutputView::printMsg);
    }

    public static Menu getMenuSelection(Scanner scanner) {
        OutputView.printMsg("원하는 기능을 선택하세요.\n");
        return Menu.getSelection(InputView.getInput(scanner));
    }

    public static void printGoBack() {
        OutputView.printInfoMsg("이전 메뉴로 돌아갑니다.");
    }

    private enum Menu {
        REGISTER_LINE("1", "1. 노선 등록", () -> lineController.addLine()),
        DELETE_LINE("2", "2. 노선 삭제", () -> lineController.deleteLine()),
        PRINT_LINES("3", "3. 노선 조회", () -> lineController.printLineList()),
        BACK("B", "B. 돌아가기", () -> printGoBack());

        private String userInput;
        private String menuName;
        private Runnable action;

        Menu(String userInput, String menuName, Runnable action) {
            this.userInput = userInput;
            this.menuName = menuName;
            this.action = action;
        }

        public String getMenuName() {
            return menuName;
        }

        public void execute() {
            action.run();
        }

        public static Menu getSelection(String input) {
            return Arrays.stream(values())
                    .filter(menu -> menu.userInput.equals(input))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("적절하지 않은 입력입니다."));
        }
    }
}
