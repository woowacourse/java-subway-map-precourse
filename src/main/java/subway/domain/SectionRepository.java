package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static void deleteSection(String name) {

    }
}
