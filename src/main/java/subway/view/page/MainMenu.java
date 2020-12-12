package subway.view.page;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class MainMenu {
    private MainMenu(){}

    public static void printMenu(){
        Arrays.stream(Menu.values())
                .map(Menu -> Menu.getMenuName()+"\n")
                .forEach(OutputView::printMsg);
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
    }
}
