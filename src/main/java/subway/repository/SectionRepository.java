package subway.repository;

import subway.domain.Section;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void createSection(Section section) {
        sections.add(section);
    }

    public static void addSection(String lineName, String stationName) {
        Section foundSection = sections.stream()
                .filter(section -> section.getLine().getName().equals(lineName))
                .findAny()
                .get();

        Station station = new Station(stationName);
        foundSection.addStation(station);
    }

    public static void addSection(String lineName, String stationName, int order) {
        Section foundSection = sections.stream()
                .filter(section -> section.getLine().getName().equals(lineName))
                .findAny()
                .get();

        Station station = new Station(stationName);
        foundSection.addStation(order, station);
    }

    public static boolean deleteSectionByName(String lineName, String stationName) {
//        sections.removeIf(section -> Objects.equals(section.getLine(), line.getName()) &&
//                Objects.equals(section.getStations()., line.getName()))
        return false;
    }
}
