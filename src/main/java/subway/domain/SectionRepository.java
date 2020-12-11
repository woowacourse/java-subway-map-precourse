package subway.domain;

import subway.enums.InitialSections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addLineToSection(Line line, List<Station> upDownLastStation) {
        sections.add(new Section(line, upDownLastStation));
    }

    public static void addStationOnLine(Line line, Station station, int position) {
        Section section = sections.stream()
                .filter(eachSection -> eachSection.getLine() == line)
                .findFirst()
                .get();
        List<Station> stations = section.getStations();
        int fixedPosition = getFixedPosition(stations, position);
        stations.add(fixedPosition, station);
    }

    public static int getFixedPosition(List<Station> stations, int position) {
        if (position < 1) return 0;
        if (position >= stations.size()) return stations.size();
        return position - 1;
    }

    public static boolean deleteStationOnLine(Line line, Station targetStation) {
        Section section = getSectionByLineName(line.getName());
        return section.getStations().removeIf(station -> station == targetStation);
    }

    public static void initializeSections() {
        for (InitialSections initialSection : InitialSections.values()) {
            Line initialLine = LineRepository.getLineByName(initialSection.getLine());
            List<Station> initialStations = initialSection.getStations()
                    .stream()
                    .map(StationRepository::getStationByName)
                    .collect(Collectors.toList());
            SectionRepository.addLineToSection(initialLine, initialStations);
        }
    }

    public static boolean isLineOnSectionDuplicated(String name) {
        if (!LineRepository.isNameDuplication(name)) {
            return false;
        }
        Line targetLine = LineRepository.getLineByName(name);
        return sections.stream()
                .map(Section::getLine)
                .anyMatch(line -> line == targetLine);
    }

    public static Section getSectionByLineName(String name) {
        Line targetLine = LineRepository.getLineByName(name);
        return sections.stream()
                .filter(section -> section.getLine() == targetLine)
                .findFirst()
                .get();
    }

    public static boolean isStationOnLine(Line line, String nameOfStation) {
        if (!StationRepository.isNameDuplication(nameOfStation)) {
            return false;
        }
        Section section = getSectionByLineName(line.getName());
        Station targetStation = StationRepository.getStationByName(nameOfStation);
        return section.getStations().stream()
                .anyMatch(station -> station == targetStation);
    }

    public static Station getStationByName(Line line, String nameOfStation) {
        Section section = getSectionByLineName(line.getName());
        Station targetStation = StationRepository.getStationByName(nameOfStation);
        return section.getStations().stream()
                .filter(station -> station == targetStation)
                .findFirst()
                .get();
    }

    public static boolean isStationInWholeSection(String name) {
        Station targetStation = StationRepository.getStationByName(name);
        return sections.stream()
                .map(Section::getStations)
                .anyMatch(stationList -> stationList.contains(targetStation));
    }

    public static boolean isStationUnder2onLine(String name) {
        Section section = getSectionByLineName(name);
        return section.getStations().size() <= 2;
    }
}
