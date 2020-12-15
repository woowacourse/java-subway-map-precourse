package subway.service;

import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.exception.station.StationNameFormatException;
import subway.exception.station.StationNameLengthException;
import subway.exception.SubwayApplicationException;

public class StationGenerateService {
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
