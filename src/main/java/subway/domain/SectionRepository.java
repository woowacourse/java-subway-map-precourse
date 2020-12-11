package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final Map<String, List<String>> sections = new LinkedHashMap<>();

    public static Map<String, List<String>> sections() {
        return Collections.unmodifiableMap(sections);
    }

    public static void addSection(String line, String startStation, String lastStation) {
        sections.put(line, new ArrayList<>(Arrays.asList(startStation, lastStation)));
    }

    public static void insertSection(String line, String station, int index) {
        sections.get(line)
                .add(index, station);
    }
}
