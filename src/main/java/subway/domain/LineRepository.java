package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String INFO = "[INFO] ";
    private static final String INFO_WITH_BORDER = "[INFO] ---";
    private static final String LINE_LIST = "## 노선 목록";
    private static final String SUBWAY_MAP = "## 지하철 노선도";
    private static final String LINE_NOT_EXIST = "[ERROR] 존재하지 않는 노선입니다.";

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void isLineExist(String lineName) {
        boolean flag = false;
        for (Line line : lines) {
            flag = line.getName().equals(lineName);
            if(flag) break;
        }
        if (!flag) {
            throw new IllegalArgumentException(LINE_NOT_EXIST);
        }
    }

    public static void printLines() {
        System.out.println(LINE_LIST);
        for (Line line : lines) {
            System.out.println(INFO + line.getName());
        }
        System.out.println();
    }

    public static void printMap() {
        System.out.println();
        System.out.println(SUBWAY_MAP);
        for (Line line : lines) {
            System.out.println(INFO + line.getName());
            System.out.println(INFO_WITH_BORDER);
            line.printStations();
        }
    }
}
