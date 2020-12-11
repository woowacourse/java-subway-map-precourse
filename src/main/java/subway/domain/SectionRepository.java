package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SectionRepository {

    private final Map<Line, List<Station>> sectionMap = new HashMap<>();

    public SectionRepository() {
    }

    public void addLine(Line sectionTitle, Station startStationInLine,
        Station endStationInLine) {
        List<Station> startToEndStation = new ArrayList<>();
        startToEndStation.add(startStationInLine);
        startToEndStation.add(endStationInLine);
        this.sectionMap.put(sectionTitle, startToEndStation);
    }

    public void addSection(Line sectionTitle, Station station, int index) {
        List<Station> stations = this.sectionMap.get(sectionTitle);
        stations.add(index, station);
        this.sectionMap.put(sectionTitle, stations);
    }

    public void deleteLine(Line sectionTitle) {
        if (!this.sectionMap.containsKey(sectionTitle)) {
            System.out.println("해당 라인이 Section 목록에 없어요.");
        }
        this.sectionMap.remove(sectionTitle);
    }

    public void deleteSection(Line sectionTitle, Station station) {
        List<Station> stations = this.sectionMap.get(sectionTitle);
        for (Station instanceStation : stations) {
            if (station.equals(instanceStation)) {
                stations.remove(station);
            }
        }
        this.sectionMap.put(sectionTitle, stations);
    }

    public boolean isExistStationInLine(Line sectionTitle, Station station) {
        if (sectionTitle == null || station == null) {
            return false;
        }
        List<Station> stations = sectionMap.get(sectionTitle);
        for (Station instanceStation : stations) {
            if (instanceStation.equals(station)) {
                return true;
            }
        }
        return false;
    }

    public Set<String> findIncludedStationSet() {
        Set<String> foundSet = new HashSet<>();
        Iterator<Line> sections = sectionMap.keySet().iterator();
        while (sections.hasNext()) {
            Line section = sections.next();
            for (Station station : sectionMap.get(section)) {
                foundSet.add(station.getName());
            }

        }
        return foundSet;
    }

    public Map<String, List> findAll() {
        Map<String, List> wholeSubwayMap = new HashMap<>();
        Iterator<Line> sectionTitles = sectionMap.keySet().iterator();
        while (sectionTitles.hasNext()) {
            Line sectionTitle = sectionTitles.next();
            List<String> stations = new ArrayList<>();
            for (Station station : sectionMap.get(sectionTitle)) {
                stations.add(station.getName());
            }
            wholeSubwayMap.put(sectionTitle.getName(), stations);
        }
        return wholeSubwayMap;
    }


}
