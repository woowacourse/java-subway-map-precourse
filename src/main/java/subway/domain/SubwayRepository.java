package subway.domain;

import java.util.*;

public class SubwayRepository {
    private static final Map<Line, List<Station>> subway = new HashMap<>();

    public static Map<Line, List<Station>> subway() {
        return Collections.unmodifiableMap(subway);
    }

    public static void addLineStation(Line line, Station station) {
        if (subway.containsKey(line)) {
            subway.get(line).add(station);
        }
    }

    public static void addLineStationSpecificPlace(Line line, Station station, Integer order) {
        if (subway.containsKey(line)) {
            subway.get(line).add(order, station);
        }
    }

    public static void addLine(Line lineByName) {
        subway.put(lineByName, new ArrayList<>());
    }

    public static void deleteStationFromLine(Line selectedLine, Station selectedStation) {
        if (subway.get(selectedLine).size() <= 2) {
            throw new IllegalArgumentException("역이 2개 이하인 노선에서는 역을 삭제할 수 없습니다.");
        }
        subway.get(selectedLine).remove(selectedStation);
    }

        public static Station findStationWithLine(Line line, String foundStationName){
        if(subway.get(line).stream().anyMatch(station -> station.equals(StationRepository.findStationByName(foundStationName)))){
            return StationRepository.findStationByName(foundStationName);
        }
        return null;
    }

    public static boolean findStationByName(String inputRemoveName) {
        boolean flag = false;
        for(Line line: subway.keySet()){
            if(subway.get(line).stream().anyMatch(station -> station.getName().equals(inputRemoveName))){
                flag = true;
            }
        }
        return flag;
    }

    public static boolean findLineByName(String nowInputName) {
        return subway().containsKey(LineRepository.findLineByName(nowInputName));
    }

}
