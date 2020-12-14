package subway.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import subway.util.Constants;

public class SectionRepository {

    private final Map<Line, List<Station>> sections = new HashMap<>();

    public SectionRepository() {
    }

    public void addStationList(Line sectionTitle, List<Station> stations) {
        sections.put(sectionTitle, new LinkedList<>(stations)); // mutable
    }

    public void addNewLine(Line line, Station startStation, Station endStation) {
        addStationList(line, List.of(startStation, endStation)); // immutable
    }

    public void addSection(Line line, Station station, int index) {
        List<Station> stations = sections.get(line);
        stations.add(index - Constants.INDEX_ARRANGE_INT, station);
    }

    public int getSize(Line line) {
        return sections.get(line).size();
    }

    public boolean isExistStationInLine(Line line, Station station) {
        return sections.getOrDefault(line, List.of()).contains(station);
    }

    public void deleteLine(Line line) {
        sections.remove(line);
    }

    public void deleteSection(Line line, Station station) {
        sections.get(line).remove(station);
    }

    public Set<Station> findAllStations() {
        return sections.values().stream() // List<Station>
            .flatMap(Collection::stream) // Station
            .collect(Collectors.toSet()); // Set.add(Station)
    }

    public Map<Line, List<Station>> findAll() {
        Map<Line, List<Station>> copiedMap = new HashMap<>();
        sections.forEach((line, stations) -> //Line, List<Station>
            copiedMap.put(line, new ArrayList<>(stations)));
        return copiedMap; // immutable
    }
}
