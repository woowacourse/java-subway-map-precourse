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

    public static List<Station> fixedStationInLineTwo() {
        List<Station> lineTwoStations = new ArrayList<>();
        lineTwoStations.add(StationRepository.STATION_KYODAE);
        lineTwoStations.add(StationRepository.STATION_GANGNAM);
        lineTwoStations.add(StationRepository.STATION_YEOKSAM);
        return lineTwoStations;
    }

    public static List<Station> fixedStationInLineThree() {
        List<Station> lineThreeStations = new ArrayList<>();
        lineThreeStations.add(StationRepository.STATION_KYODAE);
        lineThreeStations.add(StationRepository.STATION_NAMBU_TERMINAL);
        lineThreeStations.add(StationRepository.STATION_YANGJAE);
        lineThreeStations.add(StationRepository.STATION_MAEBONG);
        return lineThreeStations;
    }

    public static List<Station> fixedStationInLineShinBunDang() {
        List<Station> lineShinBunDangStations = new ArrayList<>();
        lineShinBunDangStations.add(StationRepository.STATION_GANGNAM);
        lineShinBunDangStations.add(StationRepository.STATION_YANGJAE);
        lineShinBunDangStations.add(StationRepository.STATION_YANGJAE_FOREST);
        return lineShinBunDangStations;
    }

    public static boolean isFixedStationOnLine(Station station, Line line) {
        if (!fixedLines().contains(line)) {
            return true;
        }
        if (line.equals(LINE_NUMBER_2) && fixedStationInLineTwo().contains(station)) {
            return true;
        } else if (line.equals(LINE_NUMBER_3) && fixedStationInLineThree().contains(station)) {
            return true;
        } else if (line.equals(LINE_NUMBER_SHINBUNDANG) && fixedStationInLineShinBunDang().contains(station)) {
            return true;
        }
        return false;
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
