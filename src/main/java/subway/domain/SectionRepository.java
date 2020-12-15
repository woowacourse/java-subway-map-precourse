package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SectionRepository {
    private static List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return sections;
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static void deleteSectionLine(String lineName) {
        sections.removeIf(section -> Objects.equals(section.getLine().getName(), lineName));
    }

    public static boolean deleteSectionStation(String stationName, String lineName) {
        for(Section section : sections()) {
            if(section.getLine().getName().equals(lineName)) {
                return section.getStation().removeIf(st -> Objects.equals(st.getName(), stationName));
            }
        }
        return false;
    }

    public static void  deleteSection(String name) {
        for(Section section : sections()) {
            section.getStation().removeIf(st -> Objects.equals(st.getName(), name));
        }
    }
}
