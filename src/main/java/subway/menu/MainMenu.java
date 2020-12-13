package subway.menu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class MainMenu {
    private static boolean isEnd = false;

    private MainMenu() {
    }

    public static void run(Scanner scanner) {
        do {
            printMenu();
            Menu selected = getMenuSelection(scanner);
            selected.execute(scanner);
        } while (!isEnd);
    }

    public static void printMenu() {
        OutputView.printMsg("## 메인 화면\n");
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

    public static void setEnd() {
        isEnd = true;
    }

    public static void printSubwayMap() {
        OutputView.printMsg("## 지하철 노선도 \n");
        for (Line line : LineRepository.lines()) {
            OutputView.printInfoMsg(line.toString());
            OutputView.printInfoMsg("---");
            line.getStationNames().stream()
                    .forEach(OutputView::printInfoMsg);
            OutputView.printLineSeparator();
        }
    }

    private enum Menu {
        STATION_MENU("1", "1. 역 관리\n", (scanner) -> StationMenu.run(scanner)),
        LINE_MENU("2", "2. 노선 관리\n", (scanner) -> LineMenu.run(scanner)),
        SECTION_MENU("3", "3. 구간 관리\n", (scanner) -> SectionMenu.run(scanner)),
        PRINT_MAP("4", "4. 지하철 노선도 출력\n", (scanner) -> printSubwayMap()),
        QUIT("Q", "Q. 종료\n", (scanner) -> setEnd());

        private String userInput;
        private String menuName;
        private Consumer<Scanner> nextMove;

        Menu(String userInput, String menuName, Consumer<Scanner> nextMove) {
            this.userInput = userInput;
            this.menuName = menuName;
            this.nextMove = nextMove;
        }

        public String getMenuName() {
            return menuName;
        }

        public void execute(Scanner scanner) {
            nextMove.accept(scanner);
        }

        public static Menu getSelection(String input) {
            return Arrays.stream(values())
                    .filter(menu -> menu.userInput.equals(input))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("적절하지 않은 입력입니다."));
        }
    }
}
