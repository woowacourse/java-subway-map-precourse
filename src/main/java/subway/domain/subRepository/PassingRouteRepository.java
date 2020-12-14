package subway.domain.subRepository;

import View.InputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import subway.domain.Station;

public class PassingRouteRepository{

    private static final int LEAST_STATION_NUM= 3;
    private static final int STATION_NOT_EXIST = -1;
    private List<Station> routes = new ArrayList<>();

    public PassingRouteRepository(List<Station> routes) {
        this.routes = routes;
    }

    private boolean addPossible(int whereToInsert, Station station) {
        if(isContaining(station)) {
            return false;
        }
        return true;
    }

    public void add(int position, Station station) {

        routes.add(position - 1, station);
    }

    public boolean isContaining(Station station) {
        return indexOf(station) != this.STATION_NOT_EXIST;
    }

    public int indexOf(Station station) {
        return routes.indexOf(station);
    }

    public void delete(Station station) {
        routes.remove(station);
    }

    public List<String> addStationNames(List<String> stationNames) {
        for(Station station: routes) {
            stationNames.add(station.getName());
        }
        return stationNames;
    }

    public int size() {
        return this.routes.size();
    }
}
