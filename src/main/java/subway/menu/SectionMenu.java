package subway.menu;

import java.util.List;
import java.util.Scanner;

public class SectionMenu implements Menu {


    private final static String INFO = "[INFO]";

    private final static String SECTION_ADD_MESSAGE = INFO + " 구간을 등록했습니다.";

    private final static String ERROR = "[ERROR]";

    private final static String SAME_STATION_IN_SECTION_ERROR = ERROR + " 이미 같은 역이 있습니다.";
    private final static String TERMINAL_DOES_NOT_EXIST_ERROR = ERROR + " 상행선 또는 하행선이 없는 역입니다.";
    private final static String SECTION_MINIMUM_SIZE_ERROR = ERROR + " 구간을 더 이상 삭제할 수 없습니다.";
    private final static String SAME_TERMINAL_ERROR = ERROR + " 상행선과 하행선이 같은 역입니다.";
    private final static String SECTION_INDEX_ERROR = ERROR + " 순서의 범위가 맞지 않습니다.";

    private final static String SECTION_MENU_HELLO = "## 구간 관리 화면";

    private final static String SECTION_ADD_SELECT = "1";
    private final static String SECTION_REMOVE_SELECT = "2";
    private final static String BACK_SELECT = "B";

    private final static List<String> MENU_SELECTIONS =
            List.of(SECTION_ADD_SELECT, SECTION_REMOVE_SELECT, BACK_SELECT);

    private final static String SECTION_ADD_EXPLAIN = "구간 등록";
    private final static String SECTION_REMOVE_EXPLAIN = "구간 삭제";
    private final static String BACK_EXPLAIN = "돌아가기";

    private final static String SPLIT = ". ";

    private Scanner scanner;

    public SectionMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(SECTION_MENU_HELLO).append("\n")
                .append(SECTION_ADD_SELECT).append(SPLIT).append(SECTION_ADD_EXPLAIN).append("\n")
                .append(SECTION_REMOVE_SELECT).append(SPLIT).append(SECTION_REMOVE_EXPLAIN).append("\n")
                .append(BACK_SELECT).append(SPLIT).append(BACK_EXPLAIN).append("\n");

        System.out.println(sb.toString());
    }
}
