package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LineRepository {
    private static final Map<Line, List<Station>> lines = new HashMap<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines.keySet().stream().collect(Collectors.toList()));
    }

    public static void addLine(Line line, Station upTrainStation, Station downTrainStation) {
        List<Station> stationList = new ArrayList<>();
        stationList.add(upTrainStation);
        stationList.add(downTrainStation);
        lines.put(line, stationList);
    }

    public static boolean deleteLineByName(String name) {
        Optional<Line> findLine = findByName(name);

        if (findLine.isPresent()) {
            lines.remove(findLine.get());
            return true;
        }
        return false;
    }

    public static Optional<Line> findByName(String name) {
        return lines.keySet()
            .stream()
            .filter(line -> line.getName().equals(name))
            .findAny();
    }
}
