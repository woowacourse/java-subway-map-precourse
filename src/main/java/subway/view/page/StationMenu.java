package subway.view.page;

import subway.controller.StationController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class StationMenu {
    private static StationController stationController;

    private StationMenu(){}

    public static void run(Scanner scanner){
        stationController = StationController.getInstance(scanner);
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
        OutputView.printMsg("원하는 기능을 선택하세요.");
        return Menu.getSelection(InputView.getInput(scanner));
    }

    public static void printGoBack() {
        OutputView.printInfoMsg("이전 메뉴로 돌아갑니다.");
    }

    private enum Menu {
        REGISTER_STATION("1", "1. 역 등록", () -> stationController.addStation()),
        DELETE_STATION("2", "2. 역 삭제", () -> stationController.deleteStation()),
        PRINT_STATIONS("3", "3. 역 조회", () -> stationController.printStations()),
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
