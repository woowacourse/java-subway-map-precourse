package subway.domain;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final List<Station> fixedStations = new ArrayList<>();
    static final Station STATION_KYODAE = new Station("교대역");
    static final Station STATION_GANGNAM = new Station("강남역");
    static final Station STATION_YEOKSAM = new Station("역삼역");
    static final Station STATION_NAMBU_TERMINAL = new Station("남부터미널역");
    static final Station STATION_YANGJAE = new Station("양재역");
    static final Station STATION_YANGJAE_FOREST = new Station("양재시민의숲역");
    static final Station STATION_MAEBONG = new Station("매봉역");

    public static List<Station> stations() {
        addStation(STATION_KYODAE);
        addStation(STATION_GANGNAM);
        addStation(STATION_YEOKSAM);
        addStation(STATION_NAMBU_TERMINAL);
        addStation(STATION_YANGJAE);
        addStation(STATION_YANGJAE_FOREST);
        addStation(STATION_MAEBONG);
        return Collections.unmodifiableList(stations);
    }

    public static List<Station> fixedStations() {
        fixedStations.add(STATION_KYODAE);
        fixedStations.add(STATION_GANGNAM);
        fixedStations.add(STATION_YEOKSAM);
        fixedStations.add(STATION_NAMBU_TERMINAL);
        fixedStations.add(STATION_YANGJAE);
        fixedStations.add(STATION_YANGJAE_FOREST);
        fixedStations.add(STATION_MAEBONG);
        return Collections.unmodifiableList(fixedStations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            return;
        }
        stations.add(station);
    }

    public static void isIncludedFixedStation(String name) throws IllegalArgumentException{
        if (fixedStations.removeIf(station -> Objects.equals(station.getName(), name))) {
            ErrorMessage.isNotAbleToDeleteStation();
            throw new IllegalArgumentException();
        }
    }

    public static void isIncludedLine(String name) throws IllegalArgumentException{
        for (Line line : LineRepository.lines()) {
            Optional<Station> searchedStation = line.getStation()
                    .stream().filter(station -> station.getName().equals(name)).findAny();
            if (searchedStation.isPresent()) {
                ErrorMessage.isIncludedInLine();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void deleteStation(String name) {
        isIncludedFixedStation(name);
        isIncludedLine(name);
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
