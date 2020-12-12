package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import subway.util.Constants;

public class SectionRepository {

    private final Map<Line, List<Station>> sectionMap = new HashMap<>();

    public SectionRepository() {
    }

    public void addStationList(Line sectionTitle, List<Station> stations) {
        this.sectionMap.put(sectionTitle, stations);
    }

    public void addLine(Line sectionTitle, Station startStationInLine,
        Station endStationInLine) {
        List<Station> startToEndStation = new ArrayList<>();
        startToEndStation.add(startStationInLine);
        startToEndStation.add(endStationInLine);
        this.addStationList(sectionTitle, startToEndStation);
    }

    public void addSection(Line sectionTitle, Station station, int index) {
        List<Station> stations = this.sectionMap.get(sectionTitle);
        index -= Constants.INDEX_ARRANGE_INT;
        stations.add(index - Constants.INDEX_ARRANGE_INT, station);
        this.addStationList(sectionTitle, stations);
    }

    public int getSize(Line sectionTitle) {
        List<Station> stations = this.sectionMap.get(sectionTitle);
        return stations.size();
    }

    public void deleteLine(Line sectionTitle) {
        if (this.sectionMap.containsKey(sectionTitle)) {
            this.sectionMap.remove(sectionTitle);
        }
    }

    public void deleteSection(Line sectionTitle, Station station) {
        List<Station> stations = this.sectionMap.get(sectionTitle);
        for (Station instanceStation : stations) {
            if (instanceStation.equals(stations)) {
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
        for (Line sectionTitle : this.sectionMap.keySet()) {
            for (Station station : this.sectionMap.get(sectionTitle)) {
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
