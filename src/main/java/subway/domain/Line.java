package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import subway.utils.ValidationUtils;

public class Line implements Iterable<String> {
    private static final int NAME_LENGTH_MINIMUM = 2;
    private static final int FIRST_STATION_ORDER = 1;

    private String name;
    private final List<String> stations = new ArrayList<>();

    public Line(String name) {
        ValidationUtils.validateTooShortName(name, NAME_LENGTH_MINIMUM);
        ValidationUtils.validateBlankName(name);

        this.name = name;
    }

    public static Line createLineWithStationInitializers(String name, String... stations) {
        Line line = new Line(name);
        line.stationsInitialize(Arrays.asList(stations));

        return line;
    }

    private void stationsInitialize(List<String> stationInitializer) {
        for (String stationName : stationInitializer) {
            addStation(stationName);
        }
    }

    private void addStation(String stationName) {
        ValidationUtils.validateNullStation(stationName);
        ValidationUtils.validateDuplicatedStationInLine(this, stationName);

        stations.add(stationName);
    }

    public String getName() {
        return name;
    }

    public boolean containsStation(String name) {
        return stations.contains(name);
    }

    public void addSection(int order, String stationName) {
        ValidationUtils.validateNullStation(stationName);
        ValidationUtils.validateDuplicatedStationInLine(this, stationName);
        ValidationUtils.validateSectionOutOfRange(order, FIRST_STATION_ORDER, getLastStationOrder());

        int index = order - 1;
        stations.add(index, stationName);
    }

    private int getLastStationOrder() {
        return stations.size();
    }

    public boolean deleteSection(String stationName) {
        ValidationUtils.validateNullStationInLine(this, stationName);

        return stations.removeIf(station -> Objects.equals(station, stationName));
    }

    @Override
    public Iterator<String> iterator() {
        return stations.iterator();
    }
}
