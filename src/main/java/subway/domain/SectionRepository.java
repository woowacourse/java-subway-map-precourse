package subway.domain;

import java.util.*;

public class SectionRepository {
    // TODO: List<Section> 시간 남으면 변경
    private static final HashMap<Line, List<Station>> sections = new HashMap<>();
    private static final int MINIMUM_SECTION_SIZE = 2;

    public static Map<Line, List<Station>> stations() {
        return Collections.unmodifiableMap(sections);
    }

    public static void addNewSection(Line line, Station upStation, Station downStation) {
        if (!sections.containsKey(line)) {
            sections.put(line, new ArrayList<>());
        }
        sections.get(line).add(upStation);
        sections.get(line).add(downStation);
    }

    public static void addToSection(Line line, Station station, Integer order) {
        sections.get(line).add(order, station);
    }

    public static boolean has(Line line) {
        return stations().containsKey(line);
    }

    public static boolean has(Station station) {
        for (Line line : sections.keySet()) {
            if (sections.get(line).contains(station)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSectionDeletable(Line line) {
        return sections.get(line).size() <= MINIMUM_SECTION_SIZE;
    }

    public static Map<Line, List<Station>> sections() {
        return Collections.unmodifiableMap(sections);
    }
}
