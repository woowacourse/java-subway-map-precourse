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

    public static void addStationOnLine(Line line, Station station, String position) {
        Section section = sections.stream()
                .filter(eachSection -> eachSection.getLine() == line)
                .findFirst()
                .get();
        int index = Integer.parseInt(position);
        section.getStations().add(index, station);
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
}
