package subway.view.page;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class StationMenu {

    private StationMenu(){}

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
        REGISTER_STATION("1", "1. 역 등록"),
        DELETE_STATION("2", "2. 역 삭제"),
        PRINT_STATIONS("3", "3. 역 조회"),
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
