package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.utils.StationRepositoryValidator;
import subway.view.OutputView;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static Station get(String name) {
        return stations.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(OutputView.ERROR_NOTHING));
    }

    public static void addStation(Station station) {
        StationRepositoryValidator.validateAddition(station);
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        StationRepositoryValidator.validateDeletion(name);
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
