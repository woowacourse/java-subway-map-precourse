package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
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

    public static Line getLine(String name) {
//        return (Line) lines.stream()
//                .filter(line -> line.getName().equals(name));
        int index = 0;
        for(int i=0; i<lines.size(); i++) {
            if(lines.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return lines.get(index);
    }

    public static List<Line> getLines() {
        return lines;
    }
}
