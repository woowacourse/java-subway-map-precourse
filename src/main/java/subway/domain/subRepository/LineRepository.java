package subway.domain.subRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.Line;
import subway.domain.Repository;
import subway.domain.Station;

public class LineRepository implements Repository {
    private static List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void add(int position, Line line) {
        lines.add(position, line);
    }

    public static boolean delete(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public boolean isContaining(Station station) {
        for(Line line: lines) {
            if (line.isContaining(station)) {
                return true;
            }
        }
        return false;
    }

    public boolean isRepeatedName(String Name) {
        for(Line line: lines) {
            if (line.equalWith(Name)) {
                return true;
            }
        }
        return false;
    }

    public List<String> inquiryAllStations() {
        List<String> result = new ArrayList<>();
        for(Line line: lines) {
            result.addAll(line.inquiryStations());
        }
        return result;
    }

}
