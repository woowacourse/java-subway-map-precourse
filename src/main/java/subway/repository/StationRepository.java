package subway.repository;

import subway.domain.Station;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.view.OutputView.*;

public class StationRepository {
    private static final String STATION_DUPLICATE_WARN = "역 이름은 중복이 되어서는 안됩니다.\n";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean addStation(Station station) {
        if (stations.contains(station)) {
            warnMessage(STATION_DUPLICATE_WARN);
            return false;
        }
        stations.add(station);
        return true;
    }

    public static boolean deleteStation(String name) {
        //이름으로 station 검색
        //해당 station 노선 등록 확인
        return stations.remove(station);
    }
}
