package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SectionRepository {

    // 노선의 실제 구현 (ex 2호선 = {당산역, 홍대역, 신촌역, 이대역, 아현역, 충정로역, 시청역})
    // 이게 배열 그 자체입니다.. 햇갈리지 말 것!
    private final Map<Line, List<Station>> sectionMap = new HashMap<>();

    public SectionRepository(Line sectionTitle, Station startStationInLine,
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
        // stations list (line) whole remove
    }

    public void deleteSection(Line sectionTitle, Station station) {
        List<Station> stations = sectionMap.get(sectionTitle);
        for (Station instanceStation : stations) {
            if (station.equals(instanceStation)) {
                stations.remove(station);
            }
        }
        sectionMap.put(sectionTitle, stations);
    }

    public boolean isExistStationInLine(Line sectionTitle, Station station) {
        List<Station> stations = sectionMap.get(sectionTitle);
        for (Station instanceStation : stations) {
            if (station.equals(instanceStation)) {
                return true;
            }
        }
        return false;
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
