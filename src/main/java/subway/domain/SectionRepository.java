package subway.domain;

import static subway.exception.ExceptionMessage.INVALID_ADD_SECTION_INDEX;
import static subway.exception.ExceptionMessage.INVALID_REMOVE_SECTION_STATION_LESS_THAN_MINIMUM;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SectionRepository {
    private static final Map<Line, Section> sections = new LinkedHashMap<>();
    private static final int MIN_STATION_INDEX = 1;

    public static void initialize() {
        List<Station> section1 = new ArrayList<>(List.of(getStation("교대역"), getStation("강남역"), getStation("역삼역")));
        List<Station> section2 = new ArrayList<>(List.of(getStation("교대역"), getStation("남부터미널역"), getStation("양재역"),
                getStation("매봉역")));
        List<Station> sectionNewBundang = new ArrayList(
                List.of(getStation("강남역"), getStation("양재역"), getStation("양재시민의숲역")));
        sections.put(LineRepository.findLineByName("2호선"), new Section(section1));
        sections.put(LineRepository.findLineByName("3호선"), new Section(section2));
        sections.put(LineRepository.findLineByName("신분당선"), new Section(sectionNewBundang));
    }

    private static Station getStation(String stationName) {
        return StationRepository.findStationByName(stationName);
    }

    public static void createSection(Line line, Station ascendingStation, Station descendingStation) {
        sections.put(line, new Section(new ArrayList(List.of(ascendingStation, descendingStation))));
    }

    public static void addSection(Line line, Station station, int index) {
        Section section = sections.get(line);
        if (index < MIN_STATION_INDEX || index > section.size()) {
            throw new IllegalArgumentException(INVALID_ADD_SECTION_INDEX.getMessage());
        }
        section.add(index - MIN_STATION_INDEX, station);
    }

    public static void removeSection(Line line, Station station) {
        Section section = sections.get(line);
        if (section.isRemovable()) {
            section.remove(station);
            return;
        }
        throw new IllegalArgumentException(INVALID_REMOVE_SECTION_STATION_LESS_THAN_MINIMUM.getMessage());
    }

    public static Station getAscendingStation(Line line) {
        return sections.get(line).getAscendingStation();
    }

    public static Station getDescendingStation(Line line) {
        return sections.get(line).getDescendingStation();
    }

    public static boolean contains(Line line, Station station) {
        return sections.get(line).contains(station);
    }

    public static List<Station> getSections(Line line) {
        return sections.get(line).getSection();
    }

    public static boolean containsAnyLine(Station station) {
        return sections.entrySet().stream()
                .anyMatch(entry -> sections.get(entry.getKey()).contains(station));
    }
}
