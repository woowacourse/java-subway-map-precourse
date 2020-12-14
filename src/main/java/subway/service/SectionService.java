package subway.service;

import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.dto.SectionRegistrationDto;

public class SectionService {
    private static final String NON_EXISTENT_LINE_ERROR_MESSAGE = "존재하지 않는 노선이 입력되었습니다.";
    private static final String NON_EXISTENT_STATION_ERROR_MESSAGE = "존재하지 않는 역이 입력되었습니다.";
    private static final String ALREADY_INCLUDED_STATION_ERROR_MESSAGE = "추가하려는 역이 해당 노선에 존재합니다.";
    private static final String SEQUENCE_EXCEED_STATIONS_ERROR_MESSAGE = "가능한 순서값보다 큰 값이 입력되었습니다.";

    public void addSection(SectionRegistrationDto sectionRegistrationDto) {
        String lineName = sectionRegistrationDto.getLineName();
        String stationName = sectionRegistrationDto.getStationName();
        String sequence = sectionRegistrationDto.getSequence();

        validateExistentLine(lineName);
        validateExistentStation(stationName);
        SequenceValidator.validate(sequence);
        validateIncludedStationInLine(lineName, stationName);
        validateSectionCountExceed(lineName, sequence);

        Station station = StationRepository.selectStation(sectionRegistrationDto.getStationName());
        LineRepository.addSection(lineName, station, Integer.parseInt(sequence));
    }

    private void validateExistentLine(String lineName) {
        if (!LineRepository.isExistentName(lineName)) {
            throw new IllegalArgumentException(NON_EXISTENT_LINE_ERROR_MESSAGE);
        }
    }

    private void validateExistentStation(String stationName) {
        if (!StationRepository.isExistentName(stationName)) {
            throw new IllegalArgumentException(NON_EXISTENT_STATION_ERROR_MESSAGE);
        }
    }

    private void validateIncludedStationInLine(String lineName, String stationName) {
        if (LineRepository.isIncludedSectionInLine(lineName, stationName)) {
            throw new IllegalArgumentException(ALREADY_INCLUDED_STATION_ERROR_MESSAGE);
        }
    }

    private void validateSectionCountExceed(String lineName, String sequence) {
        int stationCount = LineRepository.countNumberOfStationsInLine(lineName);
        int sequenceNumber = Integer.parseInt(sequence);
        if (stationCount + 1 < sequenceNumber) {
            throw new IllegalArgumentException(SEQUENCE_EXCEED_STATIONS_ERROR_MESSAGE);
        }
    }
}
