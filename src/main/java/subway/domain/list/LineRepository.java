package subway.domain.list;

import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static final String LINE_DUPLICATE_ERROR_MESSAGE = "[ERROR] 이미 등록된 노선 이름입니다. 중복되지 않는 역이름을 입력해주세요.";

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static List<Line> save(Line lineName) {
        if (lines.contains(lineName)) {
            throw new IllegalArgumentException(LINE_DUPLICATE_ERROR_MESSAGE);
        }
        lines.add(lineName);
        return lines;
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
