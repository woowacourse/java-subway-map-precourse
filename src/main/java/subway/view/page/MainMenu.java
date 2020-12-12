package subway.view.page;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class MainMenu {
    private static boolean isEnd = false;

    private MainMenu(){}

    public static void run(Scanner scanner){
        do{
            printMenu();
            Menu selected = getMenuSelection(scanner);
            selected.execute(scanner);
        }while(!isEnd);
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

    public static void setEnd(){
        isEnd = true;
    }

    public static void printSubwayMap(){

    }

    private enum Menu {
        STATION_MENU("1", "1. 역 관리", (scanner)-> StationMenu.run(scanner)),
        LINE_MENU("2", "2. 노선 관리", (scanner)-> LineMenu.run(scanner)),
        SECTION_MENU("3", "3. 구간 관리", (scanner)-> SectionMenu.run(scanner)),
        PRINT_MAP("4", "4. 지하철 노선도 출력", (scanner)-> printSubwayMap()),
        QUIT("Q", "Q. 종료", (scanner)-> setEnd());

        private String userInput;
        private String menuName;
        private Consumer<Scanner> nextMove;

        Menu(String userInput, String menuName, Consumer<Scanner> nextMove){
            this.userInput = userInput;
            this.menuName = menuName;
            this.nextMove = nextMove;
        }

        public String getMenuName(){
            return menuName;
        }

        public void execute(Scanner scanner){
            nextMove.accept(scanner);
        }

        public static Menu getSelection(String input){
            return Arrays.stream(values())
                    .filter(menu -> menu.userInput.equals(input))
                    .findFirst()
                    .orElseThrow(()-> new IllegalArgumentException("적절하지 않은 입력입니다."));
        }
    }
}
