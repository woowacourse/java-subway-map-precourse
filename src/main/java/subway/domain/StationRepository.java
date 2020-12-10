package subway.domain;

import java.util.*;

public class StationRepository {
    private static final String ERROR_ALREADY_EXIST= "이미 등록된 역입니다.";

    private static final List<Station> stations = new ArrayList<>();

    static {
        List<String> initialStations = new ArrayList<>(Arrays.asList(
                "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
        ));
        initialStations.stream()
                .map(Station::new)
                .forEach(StationRepository::addStation);
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(ERROR_ALREADY_EXIST);
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
