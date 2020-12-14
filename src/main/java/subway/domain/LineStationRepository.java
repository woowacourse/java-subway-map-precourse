package subway.domain;

import validator.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LineStationRepository {
    private static final String NEW_LINE = "\n";
    private static final String PRINT_INFO = "[INFO] ";
    private static final int MIN_SECTION_SIZE = 2;

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
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_LINE);
        }
        if (!StationRepository.contains(stationName)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_STATION);
        }
        List<Station> updateSection = findLineOnStations(lineName);
        Station station = StationRepository.findByName(stationName);
        if (updateSection.contains(station)) {
            throw new IllegalArgumentException(ExceptionMessage.SAME_STATION_IN_LINE);
        }
        if (updateSection.size() < Integer.parseInt(order)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_VALID_ORDER);
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
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_LINE);
        }
        if (!StationRepository.contains(stationName)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_STATION);
        }
        List<Station> sections = findLineOnStations(lineName);
        Station station = StationRepository.findByName(stationName);
        if (!sections.contains(station)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_DELETE_STATION);
        }
        if (sections.size() <= MIN_SECTION_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.DO_NOT_DELETE_SECTION);
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
