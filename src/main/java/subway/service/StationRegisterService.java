package subway.service;

import subway.exception.*;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.exception.station.StationAlreadyExistException;
import subway.repository.station.StationRepository;
import subway.specification.StationExistSpecification;

public class StationRegisterService {
    private final StationRepository stationRepository;

    public StationRegisterService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void register(Station station) {
        try {
            validateAlreadyExist(station.getName());
            stationRepository.addStation(station);
        } catch (StationAlreadyExistException e) {
            throw new SubwayApplicationException(e);
        }
    }

    private void validateAlreadyExist(StationName name) {
        StationExistSpecification stationExistSpecification =
                new StationExistSpecification(stationRepository);

        if (stationExistSpecification.isSatisfiedBy(name)) {
            throw new StationAlreadyExistException();
        }
    }

}
