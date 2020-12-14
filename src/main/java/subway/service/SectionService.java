package subway.service;

import subway.domain.Line;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.view.SectionDisplay;
import subway.view.UserInput;

public class SectionService {

    private static final String START_POSITION = "1";
    private static final String END_POSITION = "2";

    public static void save(Line newLine) {
        Section newSection = Section.newSectionWithLine(newLine);
        StationService
            .registerSectionByName(newSection, UserInput.getStartStationName(), START_POSITION);
        StationService
            .registerSectionByName(newSection, UserInput.getEndStationName(), END_POSITION);
        SectionRepository.addSection(newSection);
    }

    public static void delete(String lineName) {
        SectionRepository.deleteSection(lineName);
    }

    public static void print(){
        SectionDisplay.printAllSections(SectionRepository.sections());
    }

    public static boolean contain(String name) {
//        return SectionRepository.sections().stream()
//            .anyMatch(line -> line.getStations().stream()
//                .anyMatch(station -> station.getName().equals(name)));
        return false;
    }
}
