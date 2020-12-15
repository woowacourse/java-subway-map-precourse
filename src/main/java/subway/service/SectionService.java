package subway.service;

import subway.domain.Line;
import subway.domain.Section;
import subway.domain.Station;
import subway.repository.SectionRepository;

import java.util.List;

public class SectionService {
    public static List<Section> sections() {
        return SectionRepository.sections();
    }

    public static void createSection(String lineName) {
        Line line = new Line(lineName);
        Section section = new Section(line);
        SectionRepository.createSection(section);
    }

    public static void createSection(String lineName, String upwardStationName, String downwardStationName) {
        Line line = new Line(lineName);
        Station upwardStation = new Station(upwardStationName);
        Station downwardStation = new Station(downwardStationName);
        Section section = new Section(line, upwardStation, downwardStation);
        SectionRepository.createSection(section);
    }

    public static void addSection(String lineName, String stationName) {
        SectionRepository.addSection(lineName, stationName);
    }

    public static void addSection(String lineName, String stationName, int order) {
//        Section foundSection = SectionRepository.sections().stream()
//                .filter(section -> section.getLine().getName().equals(lineName))
//                .findAny()
//                .get();
//        foundSection.
        SectionRepository.addSection(lineName, stationName, order);
    }

    public static void deleteSectionByName(String lineName, String stationName) {
        SectionRepository.deleteSectionByName(lineName, stationName);
    }
}
