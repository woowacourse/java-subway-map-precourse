package subway.domain;

import java.util.ArrayList;
import java.util.List;

import subway.exception.BlankNameException;
import subway.exception.DuplicatedStationInLineException;
import subway.exception.TooShortNameException;
import subway.utils.RegexUtil;

public class Line {
    private static final int NAME_LENGTH_MINIMUM = 2;

    private String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        if (name.length() < NAME_LENGTH_MINIMUM) {
            throw new TooShortNameException(NAME_LENGTH_MINIMUM);
        }

        if (RegexUtil.isBlank(name)) {
            throw new BlankNameException();
        }

        this.name = name;
    }

    public static Line createLineWithTerminus(String name, String upstreamTerminus, String downstreamTerminus) {
        Line line = new Line(name);
        line.addStation(StationRepository.getStationByName(upstreamTerminus));
        line.addStation(StationRepository.getStationByName(downstreamTerminus));

        return line;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        if (containsStation(station)) {
            throw new DuplicatedStationInLineException(station.getName());
        }

        stations.add(station);
    }

    public boolean containsStation(Station station) {
        return containsStation(station.getName());
    }

    public boolean containsStation(String name) {
        return stations.stream()
                .anyMatch(streamStation -> name.equals(streamStation.getName()));
    }
}
