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

    public boolean deleteStation(String name) {  //기존


        Station station = findBy(name);
        if (!station.canRemove()) {
            throw new CannotRemoveException();
        }

        return stations().remove(station);
    }

    private boolean canRemove(String name) {
        Station station = findBy(name);
        return station.canRemove();
    }

    public Station findBy(String string) {
        return stations().stream()
                .filter(station -> station.isSameName(string))
                .findFirst()
                .orElseThrow(() -> new StationNotFountException(string));
    }

}
