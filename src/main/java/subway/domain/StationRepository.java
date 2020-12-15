package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    public static final String GYODAE_STAION = "교대역";
    public static final String GANGNAM_STAION = "강남역";
    public static final String YEOKSAM_STAION = "역삼역";
    public static final String NAMBUBUS_STAION = "남부터미널역";
    public static final String YANGJAE_STAION = "양재역";
    public static final String YANGJAE_CITIZENS_FOREST_STAION = "양재시민의숲역";
    public static final String MAEBONG_STAION = "매봉역";

    private static final List<Station> stations = new ArrayList<>();
    private static final List<Station> defaultStations = new ArrayList<>();

    public StationRepository() {
        initDefaultStations();
        for (Station station : defaultStations) {
            stations.add(new Station(station.getName()));
        }
    }

    public static void initDefaultStations() {
        defaultStations.add(new Station(GYODAE_STAION));
        defaultStations.add(new Station(GANGNAM_STAION));
        defaultStations.add(new Station(YEOKSAM_STAION));
        defaultStations.add(new Station(NAMBUBUS_STAION));
        defaultStations.add(new Station(YANGJAE_STAION));
        defaultStations.add(new Station(YANGJAE_CITIZENS_FOREST_STAION));
        defaultStations.add(new Station(MAEBONG_STAION));
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        if (isDefaultStation(name)) {
            return false;
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean isDefaultStation(String name) {
        for (Station station : defaultStations) {
            if (station.isSameName(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDuplicated(String name) {
        for (Station station : stations) {
            if (station.isSameName(name)) {
                return true;
            }
        }
        return false;
    }
}
