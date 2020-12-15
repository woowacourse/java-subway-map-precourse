package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    public static final String ERROR_MSG_NON_EXISTING_STATION = "[ERROR] 조건에 맞는 역이 없습니다.";
    public static final String PREFIX_INFO = "[INFO] ";
    public static final String NEW_LINE = "\n";
    public static final String STATIONS_LIST = "\n## 역 목록";

    static {
        stations.add(new Station("교대역"));
        stations.add(new Station("강남역"));
        stations.add(new Station("역삼역"));
        stations.add(new Station("남부터미널역"));
        stations.add(new Station("양재역"));
        stations.add(new Station("매봉역"));
        stations.add(new Station("양재시민의숲역"));
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

    public static boolean hasStation(String newStation) {
        for (Station station : stations) {
            if (station.getName().equals(newStation)) {
                return true;
            }
        }
        return false;
    }

    public static Station searchStation(String name) {
        return stations.stream()
                .filter((station) -> station.getName().equals(name))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ERROR_MSG_NON_EXISTING_STATION);
                });
    }

    public static void print() {
        String topString = STATIONS_LIST + NEW_LINE;
        StringBuilder sb = new StringBuilder();
        for (Station station : stations) {
            sb.append(PREFIX_INFO);
            sb.append(station.getName());
            sb.append(NEW_LINE);
        }
        System.out.println(topString + sb.toString());
    }

}
