package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LineRepository {
    private static final Map<Line, List<Station>> lines = new HashMap<>();

    public static Map<Line, List<Station>> lines() {
        return Collections.unmodifiableMap(lines);
    }

    public static void addLine(Line line, Station upTrainStation, Station downTrainStation) {
        List<Station> stationList = new ArrayList<>();
        stationList.add(upTrainStation);
        stationList.add(downTrainStation);
        lines.put(line, stationList);
    }

    public static void addSection(Line line, Station station, int sequence) {
        lines.get(line).add(sequence-1, station);
    }

    public static boolean deleteLineByName(String name) {
        Optional<Line> findLine = findByName(name);

        if (findLine.isPresent()) {
            lines.remove(findLine.get());
            return true;
        }
        return false;
    }

    public static boolean subtractSection(Line line, Station station) {
        return lines.get(line).removeIf(stationInSection -> stationInSection.equals(station));
    }

    public static Optional<Line> findByName(String name) {
        return lines.keySet()
            .stream()
            .filter(line -> line.getName().equals(name))
            .findAny();
    }
}
