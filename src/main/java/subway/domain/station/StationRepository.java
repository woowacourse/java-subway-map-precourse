package subway.domain.station;

import subway.domain.Line.LineRepository;
import subway.exception.AlreadyAddStationException;
import subway.exception.CannotRemoveException;
import subway.exception.StationNotFountException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static {    // 예시 추가
        new LineRepository();
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {    //기존

        if (stations().contains(station)) {
            throw new AlreadyAddStationException(station);
        }

        stations.add(station);
    }

    public boolean deleteStation(String name) {

        Station station = findBy(name);
        if (!station.canRemove()) {
            throw new CannotRemoveException(station);
        }
        station.clear();
        return stations.remove(station);
    }

    public Station findBy(String stationName) {
        return stations().stream()
                .filter(station -> station.isSameName(stationName))
                .findFirst()
                .orElseThrow(() -> new StationNotFountException(stationName));
    }

}
