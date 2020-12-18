package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final Map<String, List<Section>> sections = new HashMap<>();

    public static Map<String, List<Section>> sections() {
        return Collections.unmodifiableMap(sections);
    }

    public static void addSection(String lineName, Section section) {
        if (!sections.containsKey(lineName)) {
            sections.put(lineName, new ArrayList<>());
        }
        sections.get(lineName).add(section);
    }

    public static boolean deleteSectionByLineAndStation(String line, String station) {
        return sections.get(line).removeIf(section -> Objects.equals(section.getName(), station));
    }
}
