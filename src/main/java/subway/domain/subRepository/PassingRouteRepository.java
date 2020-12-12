package subway.domain.subRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import subway.domain.Repository;
import subway.domain.Station;

public class PassingRouteRepository implements Repository {
    private static final int LEAST_STATION_NUM= 3;
    private List<Station> routes = new ArrayList<>();

    public PassingRouteRepository(List<Station> routes) {
        this.routes = routes;
    }

    private boolean addPossible(int position, Station station) {
        if(isContaining(station)) {

        }
        return true;
    }
    public void add(int position, Station station) {

        routes.add(position - 1, station);
    }

    public boolean isContaining(Station station) {
        return routes.contains(station);
    }
    public boolean removePossible() {
        return routes.size() >= LEAST_STATION_NUM;
    }

    public void delete(String stationName) {
        if (removePossible()) {
            routes.removeIf(station -> Objects.equals(station.getName(), stationName));
        }
    }

    public List<String> addStationNames(List<String> stationNames) {

        for(Station station: routes) {
            stationNames.add(station.getName());
        }
        return stationNames;
    }
}
