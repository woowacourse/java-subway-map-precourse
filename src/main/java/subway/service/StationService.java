package subway.service;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StationService {
    private static final String DUPLICATION_ERROR_MESSAGE = "이미 해당 이름의 역이 존재합니다.";
    private static final String NON_EXISTENT_ERROR_MESSAGE = "해당 이름의 역이 존재하지 않습니다.";

    public void addStation(Station station) {
        if (StationRepository.isAlreadyExistent(station)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
        StationRepository.addStation(station);
    }

    public boolean deleteStation(String stationName) {
        if (!StationRepository.isAlreadyExistent(new Station(stationName))) {
            throw new IllegalArgumentException("NON_EXISTENT_ERROR_MESSAGE");
        }
        return StationRepository.deleteStation(stationName);
    }

    public List<String> getStationNamesWithoutRedundancy() {
        return StationRepository.stations()
                .stream()
                .distinct()
                .map(Station::getName)
                .collect(Collectors.toList());
    }
}
