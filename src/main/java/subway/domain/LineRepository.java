package subway.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
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

    public void getLine() {
        Iterator<Line> iter = lines.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().getName());
        }
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

}
