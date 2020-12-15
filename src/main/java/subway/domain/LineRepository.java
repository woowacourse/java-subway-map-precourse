package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.utils.ValidationUtils;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        addLine(Line.createWithInitialStations("2호선", "교대역", "강남역", "역삼역"));
        addLine(Line.createWithInitialStations("3호선", "교대역", "남부터미널역", "양재역", "매봉역"));
        addLine(Line.createWithInitialStations("신분당선", "강남역", "양재역", "양재시민의숲역"));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        ValidationUtils.validateDuplicatedLine(line);

        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        ValidationUtils.validateNullLine(name);

        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line getLine(String name) {
        ValidationUtils.validateNullLine(name);

        return lines.stream()
                .filter(streamLine -> name.equals(streamLine.getName()))
                .findAny().orElse(null);
    }

    public static boolean containsLine(Line line) {
        return containsLine(line.getName());
    }

    public static boolean containsLine(String name) {
        return lines.stream().anyMatch(streamLine -> name.equals(streamLine.getName()));
    }

    public static boolean anyLineContainsThisStation(String stationName) {
        for (Line line : lines) {
            if (line.containsStation(stationName)) {
                return true;
            }
        }

        return false;
    }

    public static List<String> getLineList() {
        return lines.stream().map(Line::getName).collect(Collectors.toList());
    }
}
