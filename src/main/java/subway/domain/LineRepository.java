package subway.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public static Optional<Line> getLine(String name){
        return Optional.of(lines.stream()
                .filter(line -> line.getName() != name)
                .collect(Collectors.toList())
                .get(0));
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteStationInLines(Station station){
        for(Line line : lines){
            if(line.containsStation(station)){
                line.removeStation(station);
            }
        }
    }
}
