package subway.station;

import subway.errors.DuplicateException;
import subway.errors.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class StationRepository {

    private static final String[] DEFAULT_STATION_NAMES = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    private final List<Station> stations = Arrays.stream(DEFAULT_STATION_NAMES).map(Station::new).collect(Collectors.toList());

    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public void checkDuplicateStation(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                throw new DuplicateException("역 이름");
            }
        }
    }

    public void checkStationExist(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return;
            }
        }
        throw new NotFoundException();
    }

    public Station findByName(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        throw new NotFoundException();
    }
}
