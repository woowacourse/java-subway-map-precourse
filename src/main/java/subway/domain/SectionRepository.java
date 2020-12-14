package subway.domain;

import subway.enums.Criteria;
import subway.enums.InitialSections;
import subway.enums.InitialStations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addLineToSection(Line line, List<Station> stations) {
        sections.add(new Section(line, stations));
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
        if (position < 1) return Criteria.FIRST_PLACE_ON_LINE.getValue();
        if (position > stations.size()) return stations.size();
        return position - 1;
    }

    public static boolean deleteStationOnLine(Line line, Station targetStation) {
        Section section = getSectionByLineName(line.getName());
        return section.getStations().removeIf(station -> station == targetStation);
    }

    public static boolean isLineOnSectionDuplicated(String nameOfLine) {
        if (!LineRepository.isNameDuplication(nameOfLine)) {
            return false;
        }
        Line targetLine = LineRepository.getLineByName(nameOfLine);
        return sections.stream()
                .map(Section::getLine)
                .anyMatch(line -> line == targetLine);
    }

    public static Section getSectionByLineName(String nameOfLine) {
        Line targetLine = LineRepository.getLineByName(nameOfLine);
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

    public static Station getStationByLineAndNameOfStation(Line line, String nameOfStation) {
        Section section = getSectionByLineName(line.getName());
        Station targetStation = StationRepository.getStationByName(nameOfStation);
        return section.getStations().stream()
                .filter(station -> station == targetStation)
                .findFirst()
                .get();
    }

    public static boolean isStationInSections(String nameOfStation) {
        Station targetStation = StationRepository.getStationByName(nameOfStation);
        return sections.stream()
                .map(Section::getStations)
                .anyMatch(stations -> stations.contains(targetStation));
    }

    public static boolean isStationUnder2onLine(String nameOfLine) {
        Section section = getSectionByLineName(nameOfLine);
        return section.getStations().size()
                <= Criteria.MINIMUM_NUMBER_OF_STATIONS_ON_LINE.getValue();
    }

    public static boolean deleteSectionByNameOfLine(String nameOfLine) {
        return sections.removeIf(section -> section.getLine().getName().equals(nameOfLine));
    }

    public static boolean hasTotallySameOrderOfStations(Line line) {
        Section targetSection = getSectionByLineName(line.getName());
        List<Station> targetStations = targetSection.getStations();
        return sections.stream()
                .filter(section -> section != targetSection)
                .map(Section::getStations)
                .anyMatch(stations -> Arrays.equals(stations.toArray(), targetStations.toArray()));
    }

    public static boolean hasTotallyReverseOrderOfStations(Line line) {
        Section targetSection = getSectionByLineName(line.getName());
        List<Station> targetStations = targetSection.getStations();
        Collections.reverse(targetStations);
        boolean hasTotallyReverseOrderOfStations = sections.stream()
                .filter(section -> section != targetSection)
                .map(Section::getStations)
                .anyMatch(stations -> Arrays.equals(stations.toArray(), targetStations.toArray()));
        Collections.reverse(targetStations);
        return hasTotallyReverseOrderOfStations;
    }

    public static void initializeSections() {
        for (InitialSections initialSection : InitialSections.values()) {
            Line initialLine = LineRepository.getLineByName(initialSection.getLine().getName());
            List<Station> initialStations = initialSection.getStations()
                    .stream()
                    .map(InitialStations::getName)
                    .map(StationRepository::getStationByName)
                    .collect(Collectors.toList());
            SectionRepository.addLineToSection(initialLine, initialStations);
        }
    }
}
