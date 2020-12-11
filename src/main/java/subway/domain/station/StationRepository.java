package subway.domain.station;

import subway.domain.Line.Line;
import subway.exception.AlreadyAddStationException;
import subway.exception.StationNotFountException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {    //기존

        if (stations().contains(station)) {
            throw new AlreadyAddStationException(station);
        }

        stations.add(station);
    }

    public boolean deleteStation(String name) {  //기존

        boolean result = stations.removeIf(station -> station.isSameName(name));

        if (!result) {
            throw new StationNotFountException(name);
        }
        return true;
    }


}
