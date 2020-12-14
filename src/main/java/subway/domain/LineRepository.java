package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

//    static {
//        Line line2 = new Line("2호선");
//        line2.initializeSection("교대역", "역삼역");
//        lines.add(line2);
//        Line line3 = new Line("3호선");
//        lines.add(line3);
//        Line lineSinbundang = new Line("신분당선");
//        lines.add(lineSinbundang);
//    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean hasLine(String newLine) {
        for (Line line: lines) {
            if (line.getName().equals(newLine)) {
                return true;
            }
        }
        return false;
    }

    public static void printLine() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n[INFO] 노선 목록\n");
        for (Line line : lines) {
            sb.append("[INFO] ");
            sb.append(line.getName());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }



}
