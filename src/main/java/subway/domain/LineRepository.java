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

    public static void addLine(Line addLineName) {
        for(Line line : lines) {
            if(line.getName().equals(addLineName.getName())) {
                throw new IllegalArgumentException("[ERROR] 이미 등록된 노선은 등록 불가능합니다.");
            }
        }
        lines.add(addLineName);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
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

}
