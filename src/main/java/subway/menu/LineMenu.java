package subway.menu;

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
        OutputView.printMsg("## 노선 관리 화면\n");
        Arrays.stream(Menu.values())
                .map(Menu -> Menu.getMenuName())
                .forEach(OutputView::printMsg);
        OutputView.printLineSeparator();
    }

    public static Menu getMenuSelection(Scanner scanner) {
        try {
            OutputView.printMsg("## 원하는 기능을 선택하세요.\n");
            return Menu.getSelection(InputView.getInput(scanner));
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getMenuSelection(scanner);
        }
    }

    public static void goBack() {
        OutputView.printInfoMsg("이전 메뉴로 돌아갑니다.\n");
    }

    private enum Menu {
        REGISTER_LINE("1", "1. 노선 등록\n", () -> lineController.addLine()),
        DELETE_LINE("2", "2. 노선 삭제\n", () -> lineController.deleteLine()),
        PRINT_LINES("3", "3. 노선 조회\n", () -> lineController.printLineList()),
        BACK("B", "B. 돌아가기\n", () -> goBack());

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
                    .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."));
        }
    }
}
