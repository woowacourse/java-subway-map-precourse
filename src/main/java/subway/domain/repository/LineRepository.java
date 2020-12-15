package subway.domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.Station;
import subway.exception.SubwayRelatedException;
import subway.domain.Line;

public class LineRepository{
    private static final String NO_LINE_EXIST = "노선이 존재하지 않습니다";
    private static final String ONE_LINE = "\n";
    private static List<Line> lines = new ArrayList<>();

    public LineRepository() {

    }
    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addBack(Line line) {
        lines.add(line);
    }
    public void add(int position, Line line) {
        lines.add(position, line);
    }

    public static boolean delete(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isRepeatedName(String newName) {
        for(Line line: lines) {
            if(line.getName().equals(newName)) {
                return true;
            }
        }
        return false;
    }

    public static Line searchLine(String target) {
        return lines.stream()
               .filter(line -> Objects.equals(line.getName(), target))
               .findFirst()
               .orElseThrow(() -> new SubwayRelatedException(NO_LINE_EXIST));
    }

    public static List<String> inquiryAllLines() {
        List<String> lineNames = new ArrayList<>();
        for(Line line: lines) {
            lineNames.add(line.getName());
        }
        return lineNames;
    }

    public static List<String> inquiryAllStations() {
        List<String> result = new ArrayList<>();
        for(Line line: lines) {
            System.out.println(line.getName());
            result.addAll(line.inquiryStations());
        }
        return result;
    }

    public static void deleteStation(String stationName) {
        for(Line line: lines) {
            line.getPassingRoutes().delete(StationRepository.searchStation(stationName));
        }
    }

}
