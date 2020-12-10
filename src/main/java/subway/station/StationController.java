package subway.station;

import subway.domain.Station;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static subway.station.StationValidator.*;

public class StationController {
    private static final String ALREADY_EXISTS = "중복된 이름입니다.";
    private static final String NOT_EXISTS = "존재하지 않는 역입니다.";
    private static final String UN_REMOVABLE = "노선이 등록되어 있는 역입니다.";
    private StationRepository stationRepository;

    public StationController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void createStation(String name) {
        validateName(name);
        if (stationRepository.findStationByName(name).isPresent()) {
            throw new IllegalStateException(ALREADY_EXISTS);
        }
        stationRepository.addStation(new Station(name));
    }

    public void deleteStation(String name) {
        Station station = stationRepository.findStationByName(name)
                .orElseThrow(() -> new IllegalStateException(NOT_EXISTS));
        if (!station.isRemovable()) {
            throw new IllegalStateException(UN_REMOVABLE);
        }
        stationRepository.deleteStation(station);
    }

    public StationDTO findStationByName(String name) {
        Station station = stationRepository.findStationByName(name)
                .orElseThrow(() -> new IllegalStateException(NOT_EXISTS));
        return new StationDTO(station);
    }

    public List<StationDTO> findStations(){
        Set<Station> stations = stationRepository.stations();
        return stations.stream()
                .map(StationDTO::new)
                .collect(Collectors.toList());
    }
}
