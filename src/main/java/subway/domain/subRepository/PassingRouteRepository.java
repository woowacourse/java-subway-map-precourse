package subway.domain.subRepository;

import java.util.ArrayList;
import java.util.List;

import subway.domain.Station;

public class PassingRouteRepository{

    private static final int LEAST_STATION_NUM= 3;
    private static final int STATION_NOT_EXIST = -1;
    private List<Station> routes = new ArrayList<>();

    public PassingRouteRepository(String[] stationNames) {
        configureRoutes(stationNames);
    }

    private void configureRoutes(String[] stationNames) {
        Station station;
        for(String stationName: stationNames) {
            station = StationRepository.searchStation(stationName);
            routes.add(station);
        }
    }
    public void add(int position, Station station) {

        routes.add(position - 1, station);
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
