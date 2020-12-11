package subway.domain;

import java.util.*;

public class StationRepository {
    private static final String ERROR_ALREADY_EXIST = "이미 등록된 역입니다.";
    private static final String ERROR_NOT_EXIST = "등록되지 않은 역입니다.";
    private static final String ERROR_NO_STATIONS = "등록된 역이 없습니다.";
    private static final int ZERO = 0;

    private static final List<Station> stations = new ArrayList<>();

    static {
        Initializer.initialStationRepository();
    }

    public static List<Station> stations() {
        if (stations.size() == ZERO) {
            throw new RuntimeException(ERROR_NO_STATIONS);
        }
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(ERROR_ALREADY_EXIST);
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        boolean removed = stations.removeIf(station -> Objects.equals(station.getName(), name));
        if (!removed) {
            throw new IllegalArgumentException(ERROR_NOT_EXIST);
        }
        return true;
    }

    public static Station searchByName(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        throw new RuntimeException(ERROR_NOT_EXIST);
    }
}
