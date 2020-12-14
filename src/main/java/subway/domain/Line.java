package subway.domain;

import java.util.Iterator;
import subway.utils.ValidationUtils;

public class Line implements Iterable<String> {
    private String name;
    private ResisteredStations stations;

    public Line(String name) {
        ValidationUtils.validateTooShortName(name, DomainNamingForm.LINE);
        ValidationUtils.validateInvalidSuffix(name, DomainNamingForm.LINE);

        this.name = name;
    }

    public static Line createWithInitialStations(String name, String... initialStations) {
        Line line = new Line(name);
        line.stations = new ResisteredStations(initialStations);
        return line;
    }

    public String getName() {
        return name;
    }

    public void addSection(int order, String stationName) {
        stations.addSection(order, stationName);
    }

    public void deleteSection(String stationName) {
        stations.deleteSection(stationName);
    }

    public boolean containsStation(String name) {
        return stations.contains(name);
    }

    @Override
    public Iterator<String> iterator() {
        return stations.iterator();
    }
}
