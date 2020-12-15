package subway.domain;

import java.util.*;

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

    public static boolean contains(String name) {
        for(int i=0; i<lines().size(); i++) {
            final Line line = lines().get(i);
            if(line.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static Optional<Line> findByName(String name) {
        for(int i=0; i<lines().size(); i++) {
            final Line line = lines().get(i);
            if(line.getName().equals(name)) {
                return Optional.of(line);
            }
        }
        return Optional.empty();
    }
}
