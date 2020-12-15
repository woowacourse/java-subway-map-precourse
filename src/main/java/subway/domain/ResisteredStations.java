package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import subway.utils.ValidationUtils;

public class ResisteredStations implements Iterable<String> {
    private static final int MINIMUM_STATION_COUNT = 2;

    private final List<String> stations = new ArrayList<>();

    public ResisteredStations(String[] initialStations) {
        initialize(initialStations);
    }

    private void initialize(String[] initialStations) {
        for (String stationName : Arrays.asList(initialStations)) {
            ValidationUtils.validateNullStation(stationName);
            ValidationUtils.validateDuplicatedStationInLine(this, stationName);

            stations.add(stationName);
        }
    }

    public void addSection(int order, String stationName) {
        ValidationUtils.validateNullStation(stationName);
        ValidationUtils.validateDuplicatedStationInLine(this, stationName);
        ValidationUtils.validateSectionOutOfRange(order, getLastSectionOrder());

        int index = getAddIndexFromSectionOrder(order);
        stations.add(index, stationName);
    }

    public boolean deleteSection(String stationName) {
        ValidationUtils.validateNullStationInLine(this, stationName);
        ValidationUtils.validateCannotDeleteStationMore(this, MINIMUM_STATION_COUNT);

        return stations.removeIf(station -> Objects.equals(station, stationName));
    }
    
    public boolean contains(String stationName) {
        return stations.contains(stationName);
    }

    public int size() {
        return stations.size();
    }

    private int getLastSectionOrder() {
        return size() + 1;
    }

    private int getAddIndexFromSectionOrder(int order) {
        return order - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return stations.iterator();
    }
}
