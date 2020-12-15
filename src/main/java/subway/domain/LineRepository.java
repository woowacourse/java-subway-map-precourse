package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.utils.PrintUtils;

/**
 * 지하철 노선의 객체들을 관리하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/10
 */
public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final PrintUtils printUtils = new PrintUtils();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isLineExist(Line newLine) {
        for (Line line : lines) {
            if (line.getName().equals(newLine.getName())) {
                return true;
            }
        }
        return false;
    }

    public static void printLinesList() {
        for (Line line : lines) {
            printUtils.printStation(line.getName());
        }
        System.out.println("");
    }
}
