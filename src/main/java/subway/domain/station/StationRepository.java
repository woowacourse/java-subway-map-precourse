package subway.domain.station;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.exception.AlreadyAddStationException;
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

        boolean result = stations.removeIf(station -> station.isSameName(name));

        if (!result) {
            throw new StationNotFountException(name);
        }
        return true;
    }

    public Station findBy(String string) {
        return stations().stream()
                .filter(station -> station.isSameName(string))
                .findFirst()
                .orElseThrow(() -> new StationNotFountException(string));
    }

}
