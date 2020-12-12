package subway.view.page;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class MainMenu {
    private MainMenu(){}

    public static void run(Scanner scanner){
        printMenu();
        Menu selected = getMenuSelection(scanner);
    }

    public static void printMenu(){
        Arrays.stream(Menu.values())
                .map(Menu -> Menu.getMenuName()+"\n")
                .forEach(OutputView::printMsg);
    }

    public static Menu getMenuSelection(Scanner scanner){
        OutputView.printMsg("원하는 기능을 선택하세요.");
        return Menu.getSelection(InputView.getInput(scanner));
    }

    private enum Menu {
        STATION_MENU("1", "1. 역 관리"),
        LINE_MENU("2", "2. 노선 관리"),
        SECTION_MENU("3", "3. 구간 관리"),
        PRINT_MAP("4", "4. 지하철 노선도 출력"),
        QUIT("Q", "Q. 종료");

        private String userInput;
        private String menuName;

        Menu(String userInput, String menuName){
            this.userInput = userInput;
            this.menuName = menuName;
        }

        public String getMenuName(){
            return menuName;
        }

        public static Menu getSelection(String input){
            return Arrays.stream(values())
                    .filter(menu -> menu.userInput.equals(input))
                    .findFirst()
                    .orElseThrow(()-> new IllegalArgumentException("적절하지 않은 입력입니다."));
        }
    }
}
