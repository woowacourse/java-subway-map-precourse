package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LineStationRepository {
    private static final String NEW_LINE = "\n";
    private static final String PRINT_INFO = "[INFO] ";

    private static final List<LineStation> subwayLine = new ArrayList<>();

    public static LineStation findLineStation(String lineName) {
        int findIndex = -1;
        for (LineStation lineStation : subwayLine) {
            Line line = lineStation.getLine();
            if (Objects.equals(line.getName(), lineName)) {
                findIndex = subwayLine.indexOf(lineStation);
            }
        }
        return subwayLine.get(findIndex);
    }

    public static List<Station> findLineOnStations(String lineName) {
        return findLineStation(lineName).getStations();
    }

    public static void addLineStation(LineStation lineStation) {
        subwayLine.add(lineStation);
    }

    public static void deleteLineOnSubway(String lineName) {
        subwayLine.remove(findLineStation(lineName));
    }

    public static void addSectionOnTheLine(String lineName, String stationName, String order) {
        isPossibleSection(lineName, stationName, order);
        List<Station> updateSection = findLineOnStations(lineName);
        updateSection.add(Integer.parseInt(order), StationRepository.findByName(stationName));
    }

    private static void isPossibleSection(String lineName, String stationName, String order) {
        if (!LineRepository.isLineExist(lineName)){
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 노선입니다");
        }
        if (!StationRepository.isStationExist(stationName)){
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 역 입니다");
        }
        List<Station> updateSection = findLineOnStations(lineName);
        Station station = StationRepository.findByName(stationName);
        if (updateSection.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 노선에 같은 역이 존재합니다");
        }
        if (updateSection.size() < Integer.parseInt(order)) {
            throw new IllegalArgumentException("[ERROR] 넣을 수 없는 구간 순서 입니다");
        }
    }

    public static void deleteSectionOnTheLine(String lineName, String stationName) {
        isPossibleDeleteSection(lineName, stationName);
        Station deleteStation = StationRepository.findByName(stationName);
        List<Station> selections = findLineOnStations(lineName);
        selections.remove(deleteStation);
    }

    private static void isPossibleDeleteSection(String lineName, String stationName) {
        if (!LineRepository.isLineExist(lineName)){
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 노선입니다");
        }
        if (!StationRepository.isStationExist(stationName)){
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 역 입니다");
        }
        List<Station> sections = findLineOnStations(lineName);
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
        for (LineStation lineStation : subwayLine) {
            sb.append(PRINT_INFO + lineStation.getLine().getName() + NEW_LINE);
            sb.append(PRINT_INFO + "---" + NEW_LINE);
            for (Station station : lineStation.getStations()) {
                sb.append(PRINT_INFO + station.getName() + NEW_LINE);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
