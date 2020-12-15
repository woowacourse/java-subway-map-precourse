package subway.utils;

import subway.domain.Line;
import subway.domain.repositories.LineRepository;
import subway.domain.Station;
import subway.domain.repositories.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final int NAME_MINIMUM_LENGTH = 2;

    public static boolean isValidNameLength(String name) {
        return name.length() >= NAME_MINIMUM_LENGTH;
    }

    public static boolean isExistStationName(String name) {
        List<Station> stationList = StationRepository.stations();
        for (Station station : stationList) {
            String stationName = station.getName();
            if (stationName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExistLineName(String name) {
        List<Line> lineList = LineRepository.lines();
        for (Line line : lineList) {
            String lineName = line.getName();
            if (lineName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidMainMenuInput(String inputMsg) {
        List<String> validMsgList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "Q"));
        return validMsgList.contains(inputMsg);
    }

    public static boolean isValidStationAndLineManageMenuInput(String inputMsg) {
        List<String> validMsgList = new ArrayList<>(Arrays.asList("1", "2", "3", "B"));
        return validMsgList.contains(inputMsg);
    }

    public static boolean isValidSectionManageMenuInput(String inputMsg) {
        List<String> validMsgList = new ArrayList<>(Arrays.asList("1", "2", "B"));
        return validMsgList.contains(inputMsg);
    }

    public static boolean isStationContainLine(String stationName) {
        List<String> usingStations = LineRepository.getUsingStations();
        return usingStations.contains(stationName);
    }

    public static boolean isStationAlreadyInLine(String stationName, String lineName) {
        List<String> stations = LineRepository.getStationsByLineName(lineName);
        return stations.contains(stationName);
    }

    public static boolean isValidSectionRange(String lineName, int location){
        int lineSize = LineRepository.getLineSize(lineName);
        return location >= 0 && location <= (lineSize + 1);
    }
}
