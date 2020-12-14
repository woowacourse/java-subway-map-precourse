package subway.service;

import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.exception.StationNameFormatException;
import subway.exception.StationNameLengthException;
import subway.exception.SubwayApplicationException;

public class GenerateNewStationService {
    public Station generate(String name) {
        Station station;

        try {
            StationName stationName = StationName.of(name);
            station = Station.of(stationName);
        } catch(StationNameFormatException | StationNameLengthException e) {
            throw new SubwayApplicationException(e);
        }

        return station;
    }
}
