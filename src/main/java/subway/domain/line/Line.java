package subway.domain.line;

import java.util.ArrayList;
import java.util.List;
import subway.domain.station.Station;
import subway.view.OutputView;

public class Line {
    public static final int MIN_NAME_LENGTH = 2;
    public static final int MIN_STATION_AMOUNT = 2;

    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Station station) {
        validateDuplicate(station);
        stations.add(station);
    }

    public void add(int index, Station station) {
        validateDuplicate(station);
        stations.add(index, station);
    }

    public void remove(Station station) {
        validateMinimumAmount();
        stations.remove(station);
    }

    public List<Station> getStations() {
        return stations;
    }

    public boolean hasStation(String name) {
        return stations.stream()
                .anyMatch(x -> x.getName().equals(name));
    }

    public static void validateName(String name) {
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (shorterThanMinimalLength(name)) {
            throw new IllegalArgumentException(OutputView.ERROR_NAME_SHORT);
        }
    }

    private static boolean shorterThanMinimalLength(String name) {
        return name.length() < MIN_NAME_LENGTH;
    }

    private void validateDuplicate(Station station) {
        if(isDuplicate(station)) {
            throw new IllegalArgumentException(OutputView.ERROR_DUPLICATE_STATION);
        }
    }

    private boolean isDuplicate(Station station) {
        return stations.stream()
                .map(Station::getName)
                .anyMatch(x -> x.equals(station.getName()));
    }

    private void validateMinimumAmount() {
        if(isLessThanEqualToMinimumAmount(stations.size())) {
            throw new IllegalArgumentException(OutputView.ERROR_SIZE_SMALL);
        }
    }

    private boolean isLessThanEqualToMinimumAmount(int size) {
        return size <= MIN_STATION_AMOUNT;
    }
}
