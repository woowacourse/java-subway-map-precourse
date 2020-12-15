package subway.domain;

import subway.util.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static boolean deleteSection(String stationName, String lineName) {
        for(Section section : SectionRepository.sections()) {
            if(section.getLine().getName().equals(lineName)) {
                return section.getStation().removeIf(st -> Objects.equals(st.getName(), stationName));
            }
        }
        return false;
    }

    public static void  deleteSection(String name) {
        for(Section section : SectionRepository.sections()) {
            section.getStation().removeIf(st -> Objects.equals(st.getName(), name));
        }
    }
}
