package subway.service;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StationService {
    private static final String DUPLICATION_ERROR_MESSAGE = "이미 해당 이름의 역이 존재합니다.";
    private static final String NON_EXISTENT_ERROR_MESSAGE = "해당 이름의 역이 존재하지 않습니다.";

    public void addStation(Station station) {
        if (isExistent(station)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
        StationRepository.addStation(station);
    }

    public boolean isExistent(Station station) {
        return StationRepository.isExistent(station);
    }

    public boolean deleteStation(String stationName) {
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
