package subway.domain.line;

import java.util.ArrayList;
import java.util.List;
import subway.domain.station.Station;
import subway.utils.LineValidator;
import subway.utils.NameValidator;
import subway.view.ErrorMessage;

public class Line {

    public static final int MINIMUM_NAME_LENGTH = 2;
    public static final int MINIMUM_STATION_AMOUNT = 2;
    public static final int MINIMUM_INDEX = 0;
    public static final String ENDING = "선";

    private final String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        NameValidator.validateLine(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        LineValidator.validateNoDuplicate(this, station);
        stations.add(station);
    }

    public void addStationAtSection(Station station, String stringIndex) {
        try {
            int index = getTranslatedIndex(stringIndex);
            LineValidator.validateNoDuplicate(this, station);
            stations.add(index, station);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INDEX_INVALID);
        }
    }

    private int getTranslatedIndex(String stringIndex) {
        int translatedIndex = Integer.parseInt(stringIndex) - 1;
        LineValidator.validateIndex(this, translatedIndex);
        return translatedIndex;
    }

    public void remove(Station station) {
        LineValidator.validateStationRemove(this, station);
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
