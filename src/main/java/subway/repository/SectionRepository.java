package subway.repository;

import subway.domain.Section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(String lineName, String stationName, int order) {
    }

    public static boolean deleteSectionByName(String lineName, String stationName) {
    }
}
