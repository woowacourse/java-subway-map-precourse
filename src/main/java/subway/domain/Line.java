package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private List<Station> sections = new ArrayList<>();

    public Line(String name, String upboundStationName, String downboundStationName) {
        this.name = name;
        sections.add(StationRepository.getByName(upboundStationName));
        sections.add(StationRepository.getByName(downboundStationName));
    }

    public void addSection(String stationName, String index) {
        int indexNumber = Integer.parseInt(index);
        sections.add(indexNumber, StationRepository.getByName(stationName));
    }

    public void removeSection(String stationName) {
        sections.removeIf(section -> Objects.equals(section.getName(), stationName));
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSections() {
        return sections.size();
    }

    public boolean hasStation(String stationName) {
        Station station = StationRepository.getByName(stationName);
        return sections.stream().filter(section -> Objects.equals(section, station)).count() > 0;
    }

    public boolean isValidRange(int index) {
        return (index >= 0) && (index <= sections.size());
    }
}
