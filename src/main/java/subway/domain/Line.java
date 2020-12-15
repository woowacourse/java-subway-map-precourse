package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MINIMUM_LINE_NAME_LENGTH = 2;
    private static final int MINIMUM_STATION_NUMBER_IN_LINE = 2;

    private String name;
    private final List<Station> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public void pushSections(String... stationNames) {
        for (String stationName : stationNames) {
            Station station = StationRepository.getByName(stationName);
            station.addLine();
            sections.add(station);
        }
    }

    public void addSection(String stationName, String index) {
        int indexNumber = Integer.parseInt(index) - 1;
        Station station = StationRepository.getByName(stationName);
        station.addLine();
        sections.add(indexNumber, station);
    }

    public void removeSection(String stationName) {
        Station station = StationRepository.getByName(stationName);
        station.removeLine();
        sections.removeIf(section -> Objects.equals(section, station));
    }

    public void removeAllSections() {
        for (Station section : sections) {
            section.removeLine();
        }
    }

    public boolean hasStation(String stationName) {
        Station station = StationRepository.getByName(stationName);
        return sections.stream().filter(section -> Objects.equals(section, station)).count() > 0;
    }

    public boolean isValidRange(int index) {
        return (index >= 0) && (index <= sections.size());
    }

    public boolean isRemovableNumberOfStation() {
        return sections.size() > MINIMUM_LINE_NAME_LENGTH;
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(sections);
    }

    public String getName() {
        return name;
    }

    public static int getMinimumLineNameLength() {
        return MINIMUM_LINE_NAME_LENGTH;
    }

    public static int getMinimumStationNumberInLine() {
        return MINIMUM_STATION_NUMBER_IN_LINE;
    }

    public static boolean isValidName(String name) {
        return name.length() >= MINIMUM_LINE_NAME_LENGTH;
    }
}
