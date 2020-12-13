package subway.domain.station;

import subway.domain.section.MemorySectionRepository;
import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.StationException;

import java.util.List;

public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;
    private final MemorySectionRepository sectionRepository;

    public StationServiceImpl(StationRepository stationRepository, MemorySectionRepository sectionRepository) {
        this.stationRepository = stationRepository;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Station saveStation(StationSaveReqDto saveReqDto) {
        Station station = Station.of(saveReqDto.getName());
        checkAlreadyExist(station.getName());
        stationRepository.addStation(station);
        return station;
    }

    @Override
    public Station findByName(String stationName) {
        Station station = stationRepository.findByName(stationName);
        if (station == null) {
            throw new StationException(ErrorCode.STATION_NOT_FOUND);
        }
        return station;
    }

    @Override
    public Stations getStations() {
        List<Station> stationList = stationRepository.stations();
        Stations stations = Stations.of(stationList);
        return stations;
    }

    @Override
    public boolean deleteStation(StationDeleteReqDto deleteReqDto) {
        if (containLine(deleteReqDto.getName())) {
            throw new StationException(ErrorCode.STATION_CONTAIN_LINE);
        }
        if (stationRepository.deleteStationByName(deleteReqDto.getName())) {
            return true;
        }
        throw new StationException(ErrorCode.STATION_NOT_FOUND);
    }

    @Override
    public void removeAll() {
        stationRepository.removeAll();
    }

    public boolean containLine(String stationName) {
        final boolean[] hasStation = {false};
        sectionRepository.sections().stream()
                .forEach(section -> {
                    if (section.getStationsName().contains(stationName)) {
                        hasStation[0] = true;
                    }
                });
        return hasStation[0];
    }

    @Override
    public void checkAlreadyExist(String stationName) {
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
}
