package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.exception.BlankNameException;
import subway.exception.DuplicatedStationInLineException;
import subway.exception.NullStationException;
import subway.exception.TooShortNameException;
import subway.utils.RegexUtil;

public class Line {
    private static final int NAME_LENGTH_MINIMUM = 2;

    private String name;
    private final List<String> stations = new ArrayList<>();

    public Line(String name) {
        if (name.length() < NAME_LENGTH_MINIMUM) {
            throw new TooShortNameException(NAME_LENGTH_MINIMUM);
        }

        if (RegexUtil.isBlank(name)) {
            throw new BlankNameException();
        }

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
        if (!StationRepository.containsStation(stationName)) {
            throw new NullStationException(stationName);
        }

        if (stations.contains(stationName)) {
            throw new DuplicatedStationInLineException(stationName);
        }

        stations.add(stationName);
    }

    public String getName() {
        return name;
    }

    public boolean containsStation(String name) {
        return stations.contains(name);
    }
}
