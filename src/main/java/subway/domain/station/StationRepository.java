package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.view.OutputView;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateAddition(station);
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        validateDeletion(name);
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void validateAddition(Station station) {
        validateNoDuplicate(station);
    }

    private static void validateNoDuplicate(Station station) {
        if(isDuplicate(station)) {
            throw new IllegalArgumentException(OutputView.ERROR_DUPLICATE_NAME);
        }
    }

    private static void validateDeletion(String name) {
        validateDuplicate(name);
    }

    private static void validateDuplicate(String name) {
        if(!isDuplicate(name)) {
            throw new IllegalArgumentException(OutputView.ERROR_NOTHING);
        }
    }

    private static boolean isDuplicate(Station station) {
        return stations.stream()
                .map(Station::getName)
                .anyMatch(x -> x.equals(station.getName()));
    }

    private static boolean isDuplicate(String name) {
        return stations.stream()
                .map(Station::getName)
                .anyMatch(x -> x.equals(name));
    }
}
