package subway.view.page;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class LineMenu {

    private LineMenu(){}

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

    private enum Menu{
        REGISTER_LINE("1", "1. 노선 등록"),
        DELETE_LINE("2", "2. 노선 삭제"),
        PRINT_LINES("3", "3. 노선 조회"),
        BACK("B", "B. 돌아가기");

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
