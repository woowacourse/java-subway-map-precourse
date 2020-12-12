package subway.view;

import java.util.Scanner;
import subway.controller.Function;

public class InputView {

    public static final String CHOOSE_FUNCTION = "## 원하는 기능을 선택하세요.";
    public static final String CHOOSE_ADD_STATION = "## 등록할 역 이름을 입력하세요.";
    public static final String CHOOSE_DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";
    public static final String CHOOSE_ADD_LINE = "## 등록할 노선 이름을 입력하세요.";
    public static final String CHOOSE_DELETE_LINE = "## 삭제할 노선 이름을 입력하세요.";
    public static final String CHOOSE_LINE_BEGINNING = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String CHOOSE_LINE_ENDING = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String CHOOSE_LINE = "## 노선을 입력하세요.";
    public static final String CHOOSE_STATION_NAME = "## 역이름을 입력하세요.";
    public static final String CHOOSE_ORDER = "## 순서를 입력하세요.";
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputFunction(int currentMenu) {
        System.out.println();
        OutputView.printMenu(currentMenu);
        return userStringInput(CHOOSE_FUNCTION);
    }

    public String inputName(String specificInfo) {
        System.out.println();
        return userStringInput(specificInfo);
    }

    public int inputIndex(String specificInfo) {
        System.out.println();
        return userIntegerInput(specificInfo);
    }

    private String userStringInput(String specificInfo) {
        System.out.println();
        System.out.println(specificInfo);
        return scanner.nextLine();
    }

    private int userIntegerInput(String specificInfo) {
        System.out.println();
        System.out.println(specificInfo);
        return scanner.nextInt();
    }
}
