package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LineStationRepository {
    private static final String NEW_LINE = "\n";
    private static final String PRINT_INFO = "[INFO] ";
    private static final String SEPARATOR = "[INFO] --- \n";

    private static final List<LineStation> subwayLine = new ArrayList<>();

    public static void addLineStation(LineStation lineStation) {
        subwayLine.add(lineStation);
    }

    public static void deleteLineOnSubway(String lineName) {
        subwayLine.remove(getLineStation(lineName));
    }

    public static void deleteSectionOnLine(String lineName, String deleteSection) {
        List<Station> selections = LineStationRepository.findByLineGetSections(lineName);
        selections.removeIf(station -> station.getName().equals(deleteSection));
    }

    public static LineStation getLineStation(String lineName) {
        int findIndex = -1;
        for (LineStation lineStation : subwayLine) {
            Line line = lineStation.getLine();
            if (Objects.equals(line.getName(), lineName)) {
                findIndex = subwayLine.indexOf(lineStation);
            }
        }
        return subwayLine.get(findIndex);
    }

    public static List<Station> findByLineGetSections(String lineName) {
        return getLineStation(lineName).getStations();
    }

    public static boolean isStationContainLine(Station station) {
        for (LineStation lineStation : subwayLine) {
            if (lineStation.contains(station))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LineStation lineStation : subwayLine) {
            sb.append(PRINT_INFO + lineStation.getLine().getName() + NEW_LINE);
            sb.append(SEPARATOR);
            for (Station station : lineStation.getStations()) {
                sb.append(PRINT_INFO + station.getName() + NEW_LINE);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
