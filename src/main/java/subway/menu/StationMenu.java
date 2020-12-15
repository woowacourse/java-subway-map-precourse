package subway.menu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StationMenu implements Menu {

    private final static String INFO = "[INFO]";

    private final static String STATION_REMOVED_MESSAGE = INFO + " 지하철 역을 삭제했습니다.";
    private final static String STATION_ADD_MESSAGE = INFO + " 지하철 역을 추가했습니다.";

    private final static String ERROR = "[ERROR]";

    private final static String STATION_MINIMUM_NAME_LENGTH_ERROR = ERROR + " 이름이 너무 짧습니다.";

    private final static String DUPLICATED_STATION_ERROR = ERROR + " 같은 이름의 역이 있습니다.";
    private final static String NOT_EXIST_STATION_ERROR = ERROR + " 지하철 역이 존재하지 않습니다.";


    private final static String STATION_MENU_HELLO = "## 역 관리 화면";

    private final static String STATION_ADD_SELECT = "1";
    private final static String STATION_REMOVE_SELECT = "2";
    private final static String STATION_INQUIRY_SELECT = "3";
    private final static String BACK_SELECT = "B";

    private final static List<String> MENU_SELECTIONS =
            List.of(STATION_ADD_SELECT, STATION_REMOVE_SELECT, STATION_INQUIRY_SELECT, BACK_SELECT);

    private final static String STATION_ADD_EXPLAIN = "역 등록";
    private final static String STATION_REMOVE_EXPLAIN = "역 삭제";
    private final static String STATION_INQUIRY_EXPLAIN = "역 조회";
    private final static String BACK_EXPLAIN = "돌아가기";

    private final static String SPLIT = ". ";

    private int MIN_NAME_LENGTH;
    private Scanner scanner;

    public StationMenu(Scanner scanner, int minNameLength) {
        this.scanner = scanner;
        this.MIN_NAME_LENGTH = minNameLength;
    }

    @Override
    public void printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(STATION_MENU_HELLO).append("\n")
                .append(STATION_ADD_SELECT).append(SPLIT).append(STATION_ADD_EXPLAIN).append("\n")
                .append(STATION_REMOVE_SELECT).append(SPLIT).append(STATION_REMOVE_EXPLAIN).append("\n")
                .append(STATION_INQUIRY_SELECT).append(SPLIT).append(STATION_INQUIRY_EXPLAIN).append("\n")
                .append(BACK_SELECT).append(SPLIT).append(BACK_EXPLAIN).append("\n");

        System.out.println(sb.toString());
    }

    private boolean checkSelect(String select) {
        return MENU_SELECTIONS.contains(select);
    }
}
