package subway.menu;

import java.util.List;
import java.util.Scanner;

public class LineMenu implements Menu {

    private final static String INFO = "[INFO]";

    private final static String LINE_ADD_MESSAGE = INFO + " 노선을 추가했습니다.";
    private final static String LINE_REMOVED_MESSAGE = INFO + " 노선을 삭제했습니다.";

    private final static String ERROR = "[ERROR]";

    private final static String NOT_EXIST_LINE_ERROR = ERROR + " 존재하지 않는 노선입니다.";

    private final static String LINE_MENU_HELLO = "## 노선 관리 화면";

    private final static String LINE_ADD_SELECT = "1";
    private final static String LINE_REMOVE_SELECT = "2";
    private final static String LINE_INQUIRY_SELECT = "3";
    private final static String BACK_SELECT = "B";

    private final static List<String> MENU_SELECTIONS =
            List.of(LINE_ADD_SELECT, LINE_REMOVE_SELECT, LINE_INQUIRY_SELECT, BACK_SELECT);

    private final static String LINE_ADD_EXPLAIN = "노선 등록";
    private final static String LINE_REMOVE_EXPLAIN = "노선 삭제";
    private final static String LINE_INQUIRY_EXPLAIN = "노선 조회";
    private final static String BACK_EXPLAIN = "돌아가기";

    private final static String SPLIT = ". ";

    private Scanner scanner;
    private int MIN_NAME_LENGTH;

    public LineMenu(Scanner scanner, int minNameLength) {
        this.scanner = scanner;
        this.MIN_NAME_LENGTH = minNameLength;
    }


    @Override
    public void printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(LINE_MENU_HELLO).append("\n")
                .append(LINE_ADD_SELECT).append(SPLIT).append(LINE_ADD_EXPLAIN).append("\n")
                .append(LINE_REMOVE_SELECT).append(SPLIT).append(LINE_REMOVE_EXPLAIN).append("\n")
                .append(LINE_INQUIRY_SELECT).append(SPLIT).append(LINE_INQUIRY_EXPLAIN).append("\n")
                .append(BACK_SELECT).append(SPLIT).append(BACK_EXPLAIN).append("\n");

        System.out.println(sb.toString());
    }
}
