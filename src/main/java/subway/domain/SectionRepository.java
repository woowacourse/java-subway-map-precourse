package subway.domain;

import java.util.List;
import java.util.Map;

public class SectionRepository {
    public static void addSection(Line line, Station station, int sequence){
        line.addStation(sequence, station);
    }

    public static void deleteSection(String lineName, String stationName){
        Line line = LineRepository.findLine(lineName);
        Station station = line.findStation(stationName);
        line.deleteStation(station.getName());
    }

    public static Map<List<String>, String> getSubwayMap(){
        return null;
    }
}
