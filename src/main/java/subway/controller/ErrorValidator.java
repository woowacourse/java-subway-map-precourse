package subway.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import subway.domain.LineRepository;
import subway.domain.StationRepository;


public class ErrorValidator {

    private final static List<String> managerSelection = new ArrayList<>(
        Arrays.asList("1", "2", "3", "4", "Q"));
    private final static List<String> stationLineSelection = new ArrayList<>(
        Arrays.asList("1", "2", "3", "B"));
    private final static List<String> sectionSelection = new ArrayList<>(
        Arrays.asList("1", "2", "B"));

    public static boolean checkSelectManage(String functionChoice) {
        if (!managerSelection.contains(functionChoice)) {
            return true;
        }
        return false;
    }

    public static boolean checkStationLineSelection(String userInput) {
        if (!stationLineSelection.contains(userInput)) {
            return true;
        }
        return false;
    }

    public static boolean checkSectionSelection(String userInput) {
        if (!sectionSelection.contains(userInput)) {
            return true;
        }
        return false;
    }

    public static boolean checkSameStationName(String userInput) {
        for (int i = 0; i < StationRepository.stations().size(); i++) {
            if (StationRepository.stations().get(i).getName().equals(userInput)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNameLength(String userInput) {
        if (userInput.length() < 2) {
            return true;
        }
        return false;
    }

    public static boolean checkSameLineName(String userInput) {
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            if (LineRepository.lines().get(i).getName().equals(userInput)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPositionInLine(int position, String lineName) {
        int lineNamePositionLength = 0;
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            if (LineRepository.lines().get(i).getName().equals(lineName)) {
                lineNamePositionLength = LineRepository.lines().get(i).getSectionSize();
            }
        }
        if (position > 0 && position <= lineNamePositionLength) {
            return true;
        }
        return false;
    }
}
