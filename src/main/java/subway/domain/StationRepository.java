package subway.domain;

import subway.view.ErrorView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final String[] STATIONS = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean addStation(Station station) {
        if(station.getName() == null){
            return false;
        }
        if(duplicateStation(station.getName())){
            ErrorView.duplicateName();
            return false;
        }
        stations.add(station);
        return true;
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static boolean duplicateStation(String stationName) {
        for(Station station : stations){
            if(station.getName().equals(stationName)){
                return true;
            }
        }
        return false;
    }

    public static void init() {
        for(String stationName : STATIONS){
            addStation(new Station(stationName));
        }
    }
}
