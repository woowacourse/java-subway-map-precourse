package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final List<Line> fixedLines = new ArrayList<>();
    private static final Line LINE_NUMBER_2 = new Line("2호선");
    private static final Line LINE_NUMBER_3 = new Line("3호선");
    private static final Line LINE_NUMBER_SHINBUNDANG = new Line("신분당선");

    public static List<Line> lines() {
        addLine(LINE_NUMBER_2);
        addLine(LINE_NUMBER_3);
        addLine(LINE_NUMBER_SHINBUNDANG);
        addStationsOnLine();
        return Collections.unmodifiableList(lines);
    }

    private static void addStationsOnLine() {
        LINE_NUMBER_2.addStation(StationRepository.STATION_KYODAE);
        LINE_NUMBER_2.addStation(StationRepository.STATION_GANGNAM);
        LINE_NUMBER_2.addStation(StationRepository.STATION_YEOKSAM);
        LINE_NUMBER_3.addStation(StationRepository.STATION_KYODAE);
        LINE_NUMBER_3.addStation(StationRepository.STATION_NAMBU_TERMINAL);
        LINE_NUMBER_3.addStation(StationRepository.STATION_YANGJAE);
        LINE_NUMBER_3.addStation(StationRepository.STATION_MAEBONG);
        LINE_NUMBER_SHINBUNDANG.addStation(StationRepository.STATION_GANGNAM);
        LINE_NUMBER_SHINBUNDANG.addStation(StationRepository.STATION_YANGJAE);
        LINE_NUMBER_SHINBUNDANG.addStation(StationRepository.STATION_YANGJAE_FOREST);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
