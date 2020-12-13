package subway.menu;

import subway.controller.SectionController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class SectionMenu {
    private static SectionController sectionController;

    private SectionMenu() {
    }

    public static void run(Scanner scanner) {
        sectionController = SectionController.getInstance(scanner);
        printMenu();
        Menu selected = getMenuSelection(scanner);
        selected.execute();
    }

    public static void printMenu() {
        OutputView.printMsg("## 구간 관리 화면\n");
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
        REGISTER_STATION("1", "1. 구간 등록\n", () -> sectionController.addSection()),
        DELETE_STATION("2", "2. 구간 삭제\n", () -> sectionController.deleteSection()),
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
                    .orElseThrow(() -> new IllegalArgumentException("적절하지 않은 입력입니다."));
        }
    }
}
