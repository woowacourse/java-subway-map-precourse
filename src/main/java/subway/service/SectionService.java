package subway.service;

import subway.domain.Line;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.view.MainDisplay;
import subway.view.SectionDisplay;
import subway.view.UserInput;

public class SectionService {

    private static final String START_POSITION = "1";
    private static final String END_POSITION = "2";

    public static void insertStation() {
        SectionRepository.validateSectionsEmpty();
        Section section = SectionRepository.getSectionByLineName(UserInput.getLineNameForInsert());
        Station station = StationService.getStationByName(UserInput.getStationNameForInsert());
        section.validateStationDuplicate(station);
        registerSection(section, station, UserInput.getStationPosition());
        SectionDisplay.printInsertSuccess();
    }

    public static void deleteStation() {
        SectionRepository.validateSectionsEmpty();
        Section section = SectionRepository.getSectionByLineName(UserInput.getLineNameForDelete());
        section.validateNotEnoughStations();
        section.deleteStationByName(UserInput.getStationNameForDelete());
        SectionDisplay.printDeleteSuccess();
    }


    public static void printSections() {
        SectionRepository.validateSectionsEmpty();
        MainDisplay.printAllSections(SectionRepository.sections());
    }

    public static void saveSection(Line newLine) {
        Section newSection = Section.newSectionWithLine(newLine);
        Station startStation = StationService.getStationByName(UserInput.getStartStationName());
        registerSection(newSection, startStation, START_POSITION);
        Station endStation = StationService.getStationByName(UserInput.getEndStationName());
        registerSection(newSection, endStation, END_POSITION);
        SectionRepository.addSection(newSection);
    }

    public static void deleteSection(String lineName) {
        SectionRepository.deleteSection(lineName);
    }

    public static void validateContainStation(Station station) {
        if(SectionRepository.sections().stream().anyMatch(
            line -> line.getStations().stream().anyMatch(thisStation -> thisStation.equals(station)))){
            throw new IllegalArgumentException("지하철 노선에 등록되어 있는 역은 삭제 할 수 없습니다.");
        }
    }

    private static void registerSection(Section section, Station station, String position) {
        section.addStationWithPosition(station, position);
    }
}
