package subway.domain.line;

import java.util.ArrayList;
import java.util.List;
import subway.domain.station.Station;
import subway.view.OutputView;

public class Line {
    public static final int MIN_NAME_LENGTH = 2;
    public static final int MIN_STATION_AMOUNT = 2;
    public static final int MIN_INDEX = 0;

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

    public void add(String stringIndex, Station station) {
        try {
            int translatedIndex = Integer.parseInt(stringIndex) - 1;
            validateIndexAndStation(translatedIndex, station);
            stations.add(translatedIndex, station);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputView.ERROR_INDEX);
        }
    }

    private void validateIndexAndStation(int index, Station station) {
        validateDuplicate(station);
        validateIndex(index);
    }

    public void remove(Station station) {
        validateMinimumAmount();
        validateExisting(station);
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

    private void validateExisting(Station station) {
        if(!isDuplicate(station)) {
            throw new IllegalArgumentException(OutputView.ERROR_NO_STATION);
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

    private void validateIndex(int index) {
        validateIndexRange(index);
    }

    private void validateIndexRange(int index) {
        if(lowerThanMinIndex(index) || higherThanMaxIndex(index)) {
            throw new IllegalArgumentException(OutputView.ERROR_INDEX);
        }
    }

    private boolean lowerThanMinIndex(int index) {
        return index < MIN_INDEX;
    }

    private boolean higherThanMaxIndex(int index) {
        return index > stations.size();
    }
}
