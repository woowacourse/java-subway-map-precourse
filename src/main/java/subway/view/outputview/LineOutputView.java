package subway.view.outputview;

import subway.domain.Line;

import java.util.List;

import static subway.view.outputview.OutputView.*;

public class LineOutputView {
    private static String LINE_VIEW = "노선 관리 화면\n";
    private static String LINE_MENU = "1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n";
    private static String LINE_LIST = "노선 목록";

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
}
