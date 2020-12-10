package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.exception.SubwayCustomException;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();
    public static final String NOT_VALID_STATION_EXCEPTION_MESSAGE = "존재하지 않는 역입니다.";

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static void deleteStation(String name) {
        if(!(stations.removeIf(station -> Objects.equals(station.getName(), name)))){
            throw new SubwayCustomException(NOT_VALID_STATION_EXCEPTION_MESSAGE);
        }
    }

    public static Station searchStation(String name){
        return stations.stream()
            .filter(station -> Objects.equals(station.getName(), name))
            .findFirst()
            .orElseThrow(()->new SubwayCustomException(NOT_VALID_STATION_EXCEPTION_MESSAGE));
    }


}
