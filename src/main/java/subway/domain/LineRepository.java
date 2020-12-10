package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LineRepository {

    private static final Set<Line> lines = new HashSet<>();

    public static Set<Line> lines() {
        return Collections.unmodifiableSet(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public List findAll() {
        Iterator<Line> iter = lines.iterator();
        List<String> lineNameList = new ArrayList<>();
        while (iter.hasNext()) {
            lineNameList.add(iter.next().getName());
        }
        return lineNameList;
    }

    public Line findByName(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return line;
            }
        }
        System.out.println("없는 노선 입니다");
        return null;
    }


    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

}
