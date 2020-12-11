package subway.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import subway.domain.Line;
import subway.domain.Station;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class SectionRepository {
    private static final Map<Line, List<Station>> sections = new LinkedHashMap<>();

    public static void addSection(Line line, Station station) {
        sections.computeIfAbsent(line, key -> new ArrayList<>()).add(station);
    }
}
