package subway.service;

import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StationService {
    private static final String DUPLICATION_ERROR_MESSAGE = "이미 해당 이름의 역이 존재합니다.";
    private static final String NON_EXISTENT_ERROR_MESSAGE = "해당 이름의 역이 존재하지 않습니다.";
    private static final String INCLUDED_STATION_IN_LINE_ERROR_MESSAGE = "노선에 등록되어 있는 역은 삭제할 수 없습니다.";

    public void addStation(Station station) {
        if (isExistent(station)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
        StationRepository.addStation(station);
    }

    public void addStationByName(String stationName) {
        if (isExistentName(stationName)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
        StationRepository.addStation(new Station(stationName));
    }

    public boolean isExistent(Station station) {
        return StationRepository.isExistent(station);
    }

    public boolean isExistentName(String stationName) {
        return StationRepository.isExistentName(stationName);
    }

    public boolean deleteStation(String stationName) {
        if (LineRepository.isIncludedAnyLines(stationName)) {
            throw new IllegalArgumentException(INCLUDED_STATION_IN_LINE_ERROR_MESSAGE);
        }
        if (!StationRepository.deleteStation(stationName)) {
            throw new IllegalArgumentException(NON_EXISTENT_ERROR_MESSAGE);
        }
        return true;
    }

    public List<String> getStationNames() {
        return StationRepository.stations()
                .stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }
}
