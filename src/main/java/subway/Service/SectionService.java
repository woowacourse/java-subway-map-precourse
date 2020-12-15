package subway.Service;

import subway.Exception.LineException.*;
import subway.Exception.SectionException.*;
import subway.Exception.StationException.*;
import subway.Manager.SectionManager;
import subway.domain.*;

import java.util.List;

public class SectionService {
    private static final int LINE_NAME = 0;
    private static final int SECTION_NAME = 1;
    private static final int SECTION_ORDER = 2;


    public void addSectionOnTheLine(List<String> sectionInfo) {
        try {
            isPossibleInsertSection(sectionInfo);

            List<Station> updateSection = LineStationRepository.findByLineGetSections(sectionInfo.get(LINE_NAME));
            Station section = StationRepository.findByName(sectionInfo.get(SECTION_NAME));
            int sectionOrder = Integer.parseInt(sectionInfo.get(SECTION_ORDER));
            updateSection.add(sectionOrder, section);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            SectionManager.execute();
        }
    }

    public void deleteSectionOnTheLine(List<String> deleteSectionInfo) {
        try {
            isPossibleDeleteSection(deleteSectionInfo.get(LINE_NAME), deleteSectionInfo.get(SECTION_NAME));

            Station deleteStation = StationRepository.findByName(deleteSectionInfo.get(SECTION_NAME));
            List<Station> selections = LineStationRepository.findByLineGetSections(deleteSectionInfo.get(LINE_NAME));
            selections.remove(deleteStation);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            SectionManager.execute();
        }
    }

    private void isPossibleInsertSection(List<String> sectionInfo) {
        if (!LineRepository.contains(sectionInfo.get(LINE_NAME))){
            throw new CanNotFindLineException();
        }
        if (!StationRepository.contains(sectionInfo.get(SECTION_NAME))){
            throw new CanNotFindStationException();
        }
        List<Station> updateSection = LineStationRepository.findByLineGetSections(sectionInfo.get(LINE_NAME));
        Station station = StationRepository.findByName(sectionInfo.get(SECTION_NAME));
        if (updateSection.contains(station)) {
            throw new DuplicateStationInLine();
        }
        if (updateSection.size() < Integer.parseInt(sectionInfo.get(SECTION_ORDER))) {
            throw new OutOfRangeLineException();
        }
    }


    private void isPossibleDeleteSection(String lineName, String stationName) {
        if (!LineRepository.contains(lineName)){
            throw new CanNotFindLineException();
        }
        if (!StationRepository.contains(stationName)){
            throw new CanNotFindStationException();
        }
        List<Station> sections = LineStationRepository.findByLineGetSections(lineName);
        Station station = StationRepository.findByName(stationName);
        if (!sections.contains(station)) {
            throw new CanNotFindStationException();
        }
        if (sections.size() <= LineStation.MIN_LINE_IN_SECTION_SIZE) {
            throw new ShorterThanMinLineSizeException();
        }
    }
}
