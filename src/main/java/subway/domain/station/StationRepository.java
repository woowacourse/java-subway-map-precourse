package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.common.ErrorMessageException;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final String NOT_DELETED = "삭제하지 못했습니다.";
    private static final String NOT_VALID_STATION = "없는 역입니다.";


    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static void deleteStation(String name) {
        if (!stations.removeIf(station -> Objects.equals(station.getName(), name))) {
            throw new ErrorMessageException(NOT_DELETED);
        }
    }

    public static Station findStation(String name) {
        return stations.stream().filter(item -> Objects.equals(item.getName(), name)).findFirst()
            .orElseThrow(() -> new ErrorMessageException(NOT_VALID_STATION));
    }



    public static boolean containsName(String name) {
        return stations.stream().anyMatch(item -> Objects.equals(item.getName(), name));
    }
}
