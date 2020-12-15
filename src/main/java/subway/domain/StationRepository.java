package subway.domain;

import static subway.resource.TextResource.ERROR_DELETE_STATION_IN_LINE;
import static subway.resource.TextResource.ERROR_STATION_NAME_DUPLICATED;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (!hasStation(station.getName())) {
            stations.add(station);
            return;
        }
        throw new IllegalArgumentException(ERROR_STATION_NAME_DUPLICATED);
    }

    public static boolean deleteStation(String name) {
        if (LineRepository.hasStationInLine(name)) {
            throw new IllegalArgumentException(ERROR_DELETE_STATION_IN_LINE);
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Boolean hasStation(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }
}
