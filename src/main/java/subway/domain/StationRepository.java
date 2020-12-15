package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.utils.ValidationUtils;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    static {
        addStation(new Station("교대역"));
        addStation(new Station("강남역"));
        addStation(new Station("역삼역"));
        addStation(new Station("남부터미널역"));
        addStation(new Station("양재역"));
        addStation(new Station("양재시민의숲역"));
        addStation(new Station("매봉역"));
    }

    public static void addStation(Station station) {
        ValidationUtils.validateDuplicatedStation(station.getName());

        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        ValidationUtils.validateNullStation(name);
        ValidationUtils.validateStationResisteredInCertainLine(name);

        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
    
    public static boolean containsStation(String name) {
        return stations.stream().anyMatch(streamStation -> name.equals(streamStation.getName()));
    }

    public static List<String> getStationList() {
        return stations.stream().map(Station::getName).collect(Collectors.toList());
    }
}
