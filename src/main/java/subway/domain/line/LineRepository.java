package subway.domain.line;

import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static final String LINE_DUPLICATE_ERROR_MESSAGE = "[ERROR] 이미 등록된 노선 이름입니다. 중복되지 않는 역이름을 입력해주세요.";
    public static final String LINE_CANNOT_FIND_ERROR_MESSAGE = "[ERROR] 존재하지 않는 노선입니다.";

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

    // 구간 입력할 때 존재하는 노선인지 확인
    public static Line findLineName(String lineName) {
        return lines.stream().filter(line -> line.getName().equals(lineName))
                .findAny().orElseThrow(() -> new IllegalArgumentException(LINE_CANNOT_FIND_ERROR_MESSAGE));
    }

    // station이 line에 포함되어있는지 확인
    public static boolean contains(Station station) {
        return lines.stream().anyMatch(line -> line.contains(station));
    }

    // 노선 삭제
    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    // 구간에 station추가
    public static void insertSection(String lineName, int index, Station station) {
        Line line = findLineName(lineName);
        line.insertSection(index, station);
    }
}
