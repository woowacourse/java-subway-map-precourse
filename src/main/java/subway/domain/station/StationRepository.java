package subway.domain.station;

import subway.domain.line.LineRepository;
import subway.exception.NoSuchStationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static {
        stations.add(new Station("교대역"));
        stations.add(new Station("강남역"));
        stations.add(new Station("역삼역"));
        stations.add(new Station("남부터미널역"));
        stations.add(new Station("양재역"));
        stations.add(new Station("양재시민의숲역"));
        stations.add(new Station("매봉역"));
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findStationByName(String name) {
        return stations.stream()
                .filter(station -> station.isEqualName(name))
                .findFirst()
                .orElseThrow(NoSuchStationException::new);
    }

    public static boolean isExistStation(String name) {
        return stations.stream().anyMatch(station -> station.isEqualName(name));
    }
    
    public static boolean isContainStationInLine(String name) {
        return LineRepository.lines().stream().anyMatch(line -> line.isContainStation(findStationByName(name)));
    }
}
