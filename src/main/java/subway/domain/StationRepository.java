package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("중복된 역 이름 입니다.");
        }

        stations.add(station);
    }

    public static void remove(Station station) {
        if (station.isOnLine()) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }

        stations.remove(station);
    }

    public static List<String> getStationNames() {
        return stations.stream()
                .map(Station::toString)
                .collect(Collectors.toList());
    }

    public static Station getByName(Name name) {
        return stations.stream()
                .filter(station -> station.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 역입니다."));
    }
}
