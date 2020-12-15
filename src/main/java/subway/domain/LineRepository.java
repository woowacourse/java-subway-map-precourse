package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.utils.Constant.MIN_SECTION_DELETE_STATION_COUNT;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line addLineName) {
        for (Line line : lines) {
            if (line.getName().equals(addLineName.getName())) {
                throw new IllegalArgumentException("[ERROR] 이미 등록된 노선은 등록 불가능합니다.");
            }
        }
        lines.add(addLineName);
    }

    public static boolean deleteLineByName(String name) {
        Line getLine = getLineByName(name);
        if (getLine == null) {
            throw new IllegalArgumentException("[ERROR] 등록 되어 있지 않은 노선입니다.");
        }
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line getLineByName(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return line;
            }
        }
        return null;
    }

    public static List<Line> getLines() {
        return lines;
    }

    public static void validateLineInStationCheck(String stationName) {
        for (Line line : lines) {
            List<Station> stations = line.getStations();
            stationNameEqualsCheck(stationName, stations);
        }
    }

    private static void stationNameEqualsCheck(String stationName, List<Station> stations) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                throw new IllegalArgumentException("[ERROR] 노선에 등록된 역은 삭제가 불가능합니다.");
            }
        }
    }

    public static void validateSectionDeleteStationCount(Line lines) {
        if(lines.getStations().size() < MIN_SECTION_DELETE_STATION_COUNT) {
            throw new IllegalArgumentException("[ERROR] 해당 라인에 역 개수가 2개 이하이므로 삭제가 불가능 합니다.");
        }
    }
}
