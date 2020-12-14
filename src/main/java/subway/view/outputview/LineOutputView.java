package subway.view.outputview;

import subway.domain.Line;

import java.util.List;

import static subway.view.outputview.OutputView.*;

public class LineOutputView {
    private static String LINE_LIST = "노선 목록";

    public static void showAllLines(List<Line> lines) {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(LINE_LIST);
        lines.forEach(line ->
                stringBuilder.append(INFO_SYMBOL+line.getName()));
        stringBuilder.append("\n");
        print();
    }
}
