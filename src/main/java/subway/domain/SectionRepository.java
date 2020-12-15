package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final Map<Line, Section> sections = new HashMap<>();

    public static Map<Line, Section> sections() {
        return Collections.unmodifiableMap(sections);
    }

    public static void addSection(Line line, Section section) {
        sections.put(line, section);
    }

    public static void deleteSection(Line line) {
        if (sections.containsKey(line)) {
            sections.remove(line);
        }
        throw new IllegalArgumentException();
    }

    public static Section findSection(Line line) {
        return sections.get(line);
    }
}
