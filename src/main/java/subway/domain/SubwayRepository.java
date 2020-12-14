package subway.domain;

import java.util.*;

public class SubwayRepository {

    private static final String NEW_LINE = "\n";
    private static final String PRINT_INFO = "[INFO] ";
    private static final Map<Line, List<Station>> subway = new HashMap<>();

    public static Map<Line, List<Station>> getSubway() {
        return subway;
    }

    public static void addStationOnTheLine(Line line, List<Station> stations) {
        subway.put(line, stations);
    }

    public static void deleteLineOnSubway(String lineName) {
        for (Line line : subway.keySet()) {
            if (Objects.equals(line.getName(), lineName))
                subway.remove(line);
        }
    }

    public static void addSectionOnTheLine(String lineName, String stationName, String order) {
        isPossibleSection(lineName, stationName, order);
        List<Station> updateSection = subway.get(LineRepository.findByName(lineName));

        updateSection.add(Integer.parseInt(order), StationRepository.findByName(stationName));
    }

    private static void isPossibleSection(String lineName, String stationName, String order) {
        List<Station> updateSection = subway.get(LineRepository.findByName(lineName));
        Station station = StationRepository.findByName(stationName);

        if (!LineRepository.isLineExist(lineName)){
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 노선입니다");
        }
        if (!StationRepository.isStationExist(stationName)){
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 역 입니다");
        }
        if (updateSection.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 노선에 같은 역이 존재합니다");
        }
        if (updateSection.size() < Integer.parseInt(order)) {
            throw new IllegalArgumentException("[ERROR] 넣을 수 없는 구간 순서 입니다");
        }
    }

    public static void deleteSectionOnTheLine(String lineName, String stationName) {
        isPossibleDeleteSection(lineName, stationName);
        Line line = LineRepository.findByName(lineName);
        Station deleteStation = StationRepository.findByName(stationName);
        List<Station> selections = subway.get(line);
        selections.remove(deleteStation);
    }

    private static void isPossibleDeleteSection(String lineName, String stationName) {
        if (!LineRepository.isLineExist(lineName)){
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 노선입니다");
        }
        if (!StationRepository.isStationExist(stationName)){
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 역 입니다");
        }
        List<Station> sections = subway.get(LineRepository.findByName(lineName));
        Station station = StationRepository.findByName(stationName);
        if (!sections.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 노선에 존재하지 않는 역입니다");
        }
        if (sections.size() <= 2) {
            throw new IllegalArgumentException("[ERROR] 노선에 역이 2개 이하 이므로 삭제할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : subway.keySet()) {
            sb.append(PRINT_INFO + line.getName() + NEW_LINE);
            sb.append(PRINT_INFO + "---" + NEW_LINE);
            for (Station station : subway.get(line)) {
                sb.append(PRINT_INFO + station.getName() + NEW_LINE);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
