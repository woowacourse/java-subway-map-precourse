package subway.view.outputview;

import subway.domain.Line;

import java.util.List;

import static subway.view.outputview.OutputView.*;

public class MainOutputView {
    private static String MAIN_VIEW = "메인 화면\n";
    private static String MAIN_MENU = "1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static String LINE_MAP_VIEW = "지하철 노선도";
    private static String PRINT_DELIMITER = "---";

    public static void showMenu() {
        stringBuilder.append(MENU_SYMBOL+MAIN_VIEW);
        stringBuilder.append(MAIN_MENU);
        selectMenu();
    }

    public static void selectMenu() {
        stringBuilder.append(MENU_SYMBOL+SELECT_MENU);
        print();
    }

    public static void printAll(List<Line> lines) {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(LINE_MAP_VIEW);
        lines.forEach(MainOutputView::showLine);
        print();
    }

    private static void showLine(Line line) {
        stringBuilder.append(INFO_SYMBOL);
        stringBuilder.append(line.getName());
        stringBuilder.append(INFO_SYMBOL);
        stringBuilder.append(PRINT_DELIMITER);
        showStationsOfLine(line.getStations());
        print();
    }

    private static void showStationsOfLine(List<String> stations) {
        stations.forEach(station ->
                stringBuilder.append(INFO_SYMBOL+station));
        stringBuilder.append(NEXT_LINE);
    }
}
