package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LineStationRepository {
    private Map<Line, List<Station>> lineStation;

    public LineStationRepository(Map<Line, List<Station>> lineStation) {
        this.lineStation = lineStation;
    }

    public void addLineStation(Line line, Station station) {
        lineStation.computeIfAbsent(line, Ve->new ArrayList<Station>()).add(station);
    }

    public void addStationInLine(Line line, Station station, int position) {
        lineStation.computeIfAbsent(line, Ve->new ArrayList<Station>()).add(position, station);
    }

    public void deleteLineStation(Line line) {
        LineRepository.deleteLineByName(line.getName());
        lineStation.remove(line);
    }

    public boolean findStationInLine(Line line, Station station) {
        return lineStation.get(line).contains(station);
    }

    public void deleteStationInLineByName(Line line, String name) {
        lineStation.get(line).removeIf(station -> Objects.equals(station.getName(), name));
    }

    public Map<Line, List<Station>> getLineStation() {
        return lineStation;
    }

    public int getLineStationSize() {
        return lineStation.size();
    }

    public int getStationSizeOfLine(Line line) {
        return lineStation.get(line).size();
    }

    public boolean findStationInLine(Station station) {
        for (Line line : lineStation.keySet()) {
            if (lineStation.get(line).contains(station)) {
                return true;
            }
        }
        return false;
    }

    public void printAllLineStation() {
        System.out.println("\n## 지하철 노선도");
        lineStation.forEach((line, stations) -> {
            System.out.println(line.toString());
            System.out.println("[INFO] ---");
            stations.forEach(station -> {
                System.out.println(station.toString());
            });
            System.out.println();
        });
    }
}