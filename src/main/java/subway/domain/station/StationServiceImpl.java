package subway.domain.station;

import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.StationException;

import java.util.List;

public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Station saveStation(StationSaveReqDto saveReqDto) {
        Station station = Station.of(saveReqDto.getName());
        checkExist(station.getName());
        stationRepository.addStation(station);
        return station;
    }

    @Override
    public Stations getStations() {
        List<Station> stationList = stationRepository.stations();
        Stations stations = Stations.of(stationList);
        return stations;
    }

    @Override
    public void deleteStation(StationDeleteReqDto deleteReqDto) {
        if (stationRepository.deleteStationByName(deleteReqDto.getName())) {
            return;
        }
        throw new StationException(ErrorCode.STATION_NOT_FOUND);
    }

    @Override
    public void checkExist(String stationName) {
        Station stationFindByName = stationRepository.findByName(stationName);
        if (stationFindByName != null) {
            throw new StationException(ErrorCode.STATION_ALREADY_EXIST);
        }
    }

    @Override
    public void checkNotFound(String stationName) {
        Station stationFindByName = stationRepository.findByName(stationName);
        if (stationFindByName == null) {
            throw new StationException(ErrorCode.STATION_NOT_FOUND);
        }
    }

    @Override
    public void removeAll() {
        stationRepository.removeAll();
    }
}
