package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LineStationRepository {
    private Map<Line, List<Station>> lineStation;

    public LineStationRepository(Map<Line, List<Station>> lineStation) {
        this.lineStation = lineStation;
    }

    public void addLineStation(Line line, Station station) {
        lineStation.computeIfAbsent(line, Ve->new ArrayList<Station>()).add(station);
    }

    public void deleteLineStation(Line line) {
        LineRepository.deleteLineByName(line.getName());
        lineStation.remove(line);
    }

    public Map<Line, List<Station>> getLineStation() {
        return lineStation;
    }

    public List<Station> getStationsOfLine(Line line) {
        return lineStation.get(line);
    }

    public int getLineStationSize() {
        return lineStation.size();
    }

    public int getStationSizeOfLine(Line line) {
        return lineStation.get(line).size();
    }
}