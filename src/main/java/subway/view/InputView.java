package subway.view;

import java.util.Scanner;

public class InputView {

    public static final String CHOOSE_FUNCTION = "## 원하는 기능을 선택하세요.";

    public static final String CHOOSE_STATION_ADD = "## 등록할 역 이름을 입력하세요.";
    public static final String CHOOSE_STATION_DELETE = "## 삭제할 역 이름을 입력하세요.";

    public static final String CHOOSE_LINE_ADD = "## 등록할 노선 이름을 입력하세요.";
    public static final String CHOOSE_LINE_DELETE = "## 삭제할 노선 이름을 입력하세요.";
    public static final String CHOOSE_LINE_STARTING = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String CHOOSE_LINE_FINISHING = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    public static final String CHOOSE_SECTION_ADD_LINE = "## 노선을 입력하세요.";
    public static final String CHOOSE_SECTION_ADD_STATION = "## 역이름을 입력하세요.";
    public static final String CHOOSE_SECTION_ADD_ORDER = "## 순서를 입력하세요.";
    public static final String CHOOSE_SECTION_DELETE_LINE = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String CHOOSE_SECTION_DELETE_STATION = "## 삭제할 구간의 역을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputFunction() {
        return userStringInput(CHOOSE_FUNCTION);
    }

    public String inputName(String specificInfo) {
        return userStringInput(specificInfo);
    }

    public String inputIndex(String specificInfo) {
        return userStringInput(specificInfo);
    }

    private String userStringInput(String specificInfo) {
        System.out.println();
        System.out.println(specificInfo);
        return scanner.nextLine().trim();
    }
}
