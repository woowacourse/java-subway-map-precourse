package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.SubwayExceptions.ExceptionCannotDeleteStationOnLine;
import subway.SubwayExceptions.ExceptionStationNameNoExists;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            return;
        }
        stations.add(station);
    }

    public static void deleteStation(String name) throws ExceptionStationNameNoExists {
        if (!stations.removeIf(station -> Objects.equals(station.getName(), name))) {
            throw new ExceptionStationNameNoExists();
        }
//        LineRepository.deleteStationsOnLineByName(name);
    }

    public static void canDeleteStation(String name) throws ExceptionCannotDeleteStationOnLine {
        if (StationRepository.stations().contains(StationRepository.getStationByName(name))) {
            throw new ExceptionCannotDeleteStationOnLine();
        }
    }

    public static Station getStationByName(String stationName) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        return null;
    }
}
