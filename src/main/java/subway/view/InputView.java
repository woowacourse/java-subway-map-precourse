package subway.view;

import java.util.Scanner;
import subway.controller.Function;

public class InputView {

    private static final String CHOOSE_FUNCTION = "## 원하는 기능을 선택하세요.";
    private static final String CHOOSE_ADD_STATION = "## 등록할 역 이름을 입력하세요.";
    private static final String CHOOSE_DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";
    private static final String CHOOSE_ADD_LINE = "## 등록할 노선 이름을 입력하세요.";
    private static final String CHOOSE_DELETE_LINE = "## 삭제할 노선 이름을 입력하세요.";
    private static final String CHOOSE_LINE_BEGINNING = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String CHOOSE_LINE_ENDING = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputFunction(int currentMenu) {
        System.out.println();
        OutputView.printMenu(currentMenu);
        return userStringInput(CHOOSE_FUNCTION);
    }

    public String inputAddStationName() {
        System.out.println();
        return userStringInput(CHOOSE_ADD_STATION);
    }

    public String inputDeleteStationName() {
        System.out.println();
        return userStringInput(CHOOSE_DELETE_STATION);
    }

    private String userStringInput(String specificInfo) {
        System.out.println();
        System.out.println(specificInfo);
        return scanner.nextLine();
    }
}
