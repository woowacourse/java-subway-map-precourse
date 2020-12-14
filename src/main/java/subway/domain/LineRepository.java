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

    public static List<Line> fixedLines() {
        fixedLines.add(LINE_NUMBER_2);
        fixedLines.add(LINE_NUMBER_3);
        fixedLines.add(LINE_NUMBER_SHINBUNDANG);
        addStationsOnLine();
        return Collections.unmodifiableList(fixedLines);
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
        if (lines.contains(line)) {
            return;
        }
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        if (fixedLines.removeIf(line -> Objects.equals(line.getName(), name))) {
            ErrorMessage.isNotAbleToDeleteLine();
            return false;
        }
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
