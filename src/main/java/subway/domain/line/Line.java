package subway.domain.line;

import java.util.ArrayList;
import java.util.List;
import subway.domain.station.Station;
import subway.utils.LineValidator;
import subway.view.OutputView;

public class Line {

    public static final int MINIMUM_NAME_LENGTH = 2;
    public static final int MINIMUM_STATION_AMOUNT = 2;
    public static final int MINIMUM_INDEX = 0;

    private final String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        LineValidator.validateNoDuplicate(this, station);
        stations.add(station);
    }

    public void addStationAtSection(String stringIndex, Station station) {
        try {
            int translatedIndex = Integer.parseInt(stringIndex) - 1;
            LineValidator.validateIndex(this, translatedIndex);
            LineValidator.validateNoDuplicate(this, station);
            stations.add(translatedIndex, station);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputView.ERROR_INDEX);
        }
    }

    public void remove(Station station) {
        LineValidator.validateRemove(this, station);
        stations.remove(station);
    }

    public List<Station> getStations() {
        return stations;
    }

    public boolean hasStation(String name) {
        return stations.stream()
                .anyMatch(x -> x.getName().equals(name));
    }
}
