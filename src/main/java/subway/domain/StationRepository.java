package subway.domain;

import subway.domain.exception.AlreadyExistStationException;
import subway.domain.exception.NotExistStationException;
import subway.utils.InputValidator;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public StationRepository() {
        init();
    }

    private void init() {
        List<String> initStation = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String station : initStation) {
            stations.add(new Station(station));
        }
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        InputValidator.validStationName(station.getName());
        existStationName(station.getName());
        stations.add(station);
    }

    public boolean deleteStation(String name) {
        InputValidator.validStationName(name);
        notExistStationName(name);
        LineRepository.duplicateStationInLine(name);
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void existStationName(String name) {
        stations.stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findAny()
                .ifPresent(s -> {
                    throw new AlreadyExistStationException();
                });
    }

    public static void notExistStationName(String name) {
        stations.stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findAny()
                .orElseThrow(() -> new NotExistStationException());
    }
}
