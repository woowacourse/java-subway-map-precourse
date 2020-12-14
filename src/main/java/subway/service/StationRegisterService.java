package subway.service;

import subway.exception.*;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.repository.station.StationRepository;
import subway.specification.StationExistSpecification;

public class StationRegisterService {
    private final StationRepository stationRepository;

    public StationRegisterService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void register(String name) {
        try {
            StationName stationName = StationName.of(name);
            Station station = Station.of(stationName);
            validateAlreadyExist(stationName);
            stationRepository.addStation(station);
        } catch (StationNotFoundException e) {
            throw new StationApplicationException(e);
        } catch (StationNameFormatException e) {
            throw new StationApplicationException(e);
        } catch (StationNameLengthException e) {
            throw new StationApplicationException(e);
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
