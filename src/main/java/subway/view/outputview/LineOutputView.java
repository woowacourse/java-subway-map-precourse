package subway.view.outputview;

import subway.domain.Line;

import java.util.List;

import static subway.view.outputview.OutputView.*;

public class LineOutputView {
    private static String LINE_VIEW = "노선 관리 화면\n";
    private static String LINE_MENU = "1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n";
    private static String LINE_LIST = "노선 목록";
    private static String REGISTER_LINE = "등록할 노선 이름을 입력하세요\n";
    private static String FIRST_STATION_NAME = "등록할 노선의 상행 종점역 이름을 입력하세요.\n";
    private static String LAST_STATION_NAME = "등록할 노선의 하행 종점역 이름을 입력하세요.\n";
    private static String DELETE_LINE = "삭제할 노선 이름을 입력하세요.\n";
    private static String SUCCESS_ADD_LINE = "지하철 노선이 등록되었습니다.\n";
    private static String SUCCESS_DELETE_LINE = "지하철 노선이 삭제되었습니다.\n";

    public static void showMenu() {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(LINE_VIEW);
        stringBuilder.append(LINE_MENU);
        selectMenu();
    }

    public static void showAllLines(List<Line> lines) {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(LINE_LIST);
        lines.forEach(line ->
                stringBuilder.append(INFO_SYMBOL+line.getName()));
        stringBuilder.append("\n");
        print();
    }

    public static void registerLineName() {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(REGISTER_LINE);
        print();
    }

    public static void firstLineName() {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(FIRST_STATION_NAME);
        print();
    }

    public static void lastLineName() {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(LAST_STATION_NAME);
        print();
    }
}
