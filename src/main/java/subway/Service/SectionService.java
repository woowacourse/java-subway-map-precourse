package subway.Service;

import subway.Manager.SectionManager;
import subway.domain.LineRepository;
import subway.domain.LineStationRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import validator.ExceptionMessage;

import java.util.List;

public class SectionService {

    private static final int MIN_SECTION_SIZE = 2;
    private static final String SECTION_INSERT = "1";
    private static final String SECTION_DELETE = "2";
    private static final int LINE_NAME = 0;
    private static final int SECTION_NAME = 1;
    private static final int SECTION_ORDER = 2;


    public void addSectionOnTheLine(List<String> insetSectionInfo) {
        try {
            String lineName = insetSectionInfo.get(LINE_NAME);
            String stationName = insetSectionInfo.get(SECTION_NAME);
            String order = insetSectionInfo.get(SECTION_ORDER);
            isPossibleSection(lineName, stationName, order);
            List<Station> updateSection = LineStationRepository.findByLineGetSections(lineName);
            updateSection.add(Integer.parseInt(order), StationRepository.findByName(stationName));
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            SectionManager.execute(SECTION_INSERT);
        }
    }

    public  void deleteSectionOnTheLine(List<String> deleteSectionInfo) {
        try {
            isPossibleDeleteSection(deleteSectionInfo.get(LINE_NAME), deleteSectionInfo.get(SECTION_NAME));
            Station deleteStation = StationRepository.findByName(deleteSectionInfo.get(SECTION_NAME));
            List<Station> selections = LineStationRepository.findByLineGetSections(deleteSectionInfo.get(LINE_NAME));
            selections.remove(deleteStation);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            SectionManager.execute(SECTION_DELETE);
        }
    }

    private void isPossibleSection(String lineName, String stationName, String order) {
        if (!LineRepository.contains(lineName)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_LINE);
        }
        if (!StationRepository.contains(stationName)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_STATION);
        }
        List<Station> updateSection = LineStationRepository.findByLineGetSections(lineName);
        Station station = StationRepository.findByName(stationName);
        if (updateSection.contains(station)) {
            throw new IllegalArgumentException(ExceptionMessage.SAME_STATION_IN_LINE);
        }
        if (updateSection.size() < Integer.parseInt(order)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_VALID_ORDER);
        }
    }


    private void isPossibleDeleteSection(String lineName, String stationName) {
        if (!LineRepository.contains(lineName)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_LINE);
        }
        if (!StationRepository.contains(stationName)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_STATION);
        }
        List<Station> sections = LineStationRepository.findByLineGetSections(lineName);
        Station station = StationRepository.findByName(stationName);
        if (!sections.contains(station)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_DELETE_STATION);
        }
        if (sections.size() <= MIN_SECTION_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.DO_NOT_DELETE_SECTION);
        }
    }
}
