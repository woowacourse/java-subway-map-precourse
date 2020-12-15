package subway.domain;

import subway.view.OutputViewOfError;
import subway.view.OutputViewOfInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String LINE_LIST = "## 노선 목록";
    private static final int MIN_STATION_SIZE = 2;

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static boolean addLine(Line line) {
        lines.add(line);
        return true;
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void printLines() {
        System.out.println(LINE_LIST);
        lines.forEach(line -> OutputViewOfInfo.printLines(line.getName()));
    }

    public static boolean isExistLine(String lineName) {
        return lines.stream().anyMatch(line -> line.getName().equals(lineName));
    }

    public static Line searchByName(String lineName) {
        if (lines.stream().noneMatch(line -> line.getName().equals(lineName))) {
            OutputViewOfError.isNotExistLine();
            return null;
        }
        return lines.stream().filter(line -> line.getName().equals(lineName))
                .findAny().get();
    }

    public static boolean deleteStationByName(Line deleteLine, String stationName) {
        if (deleteLine == null) {
            OutputViewOfError.isNotExistLine();
            return false;
        }
        if (deleteLine.getStations().size() < MIN_STATION_SIZE) {
            OutputViewOfError.cannotDeleteStationInLine();
            return false;
        }
        return deleteLine.getStations().removeIf(station -> station.getName().equals(stationName));
    }
}
