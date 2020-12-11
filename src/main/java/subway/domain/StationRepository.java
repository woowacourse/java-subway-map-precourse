package subway.domain;

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
        validateOverlappedStation(station);
        stations.add(station);
    }

    private static void validateOverlappedStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("");
        }
    }

    public static boolean deleteStation(String name) {
        if (LineRepository.contains(name)) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제가 불가능합니다.");
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
