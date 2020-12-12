package utils;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import view.OutputView;


import java.util.List;

public class VerifyInput {

    private static final int PREVIOUS_INDEX = -1;
    private static final int MIN_NAME_LENGTH = 2;
    private static final int NUM_MIN_STATION = 2;
    private static final String SUFFIX_STATION = "역";
    private static final String SUFFIX_LINE = "선";

    public static void functionSelect(List<String> choices, String command) {
        if (!choices.contains(command)) {
            OutputView.printError(OutputView.MESSAGE_ERROR_INVALID_SELECT);
            throw new IllegalArgumentException();
        }
    }

    public static void lengthOfName(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            OutputView.printError(OutputView.MESSAGE_ERROR_TOO_SHORT_NAME);
            throw new IllegalArgumentException();
        }
    }

    public static void suffixStationName(String stationName) {
        if (!stationName.substring(stationName.length() + PREVIOUS_INDEX).equals(SUFFIX_STATION)) {
            OutputView.printError(OutputView.MESSAGE_ERROR_STATION_NAME_SUFFIX);
            throw new IllegalArgumentException();
        }
    }

    public static void suffixLineName(String lineName) {
        if (!lineName.substring(lineName.length() + PREVIOUS_INDEX).equals(SUFFIX_LINE)) {
            OutputView.printError(OutputView.MESSAGE_ERROR_LINE_NAME_SUFFIX);
            throw new IllegalArgumentException();
        }
    }

    public static void duplicateStationName(String stationName) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                OutputView.printError(OutputView.MESSAGE_ERROR_ALREADY_EXIST_STATION_NAME);
                throw new IllegalArgumentException();
            }
        }
    }

    public static void duplicateLineName(String lineName) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName)) {
                OutputView.printError(OutputView.MESSAGE_ERROR_ALREADY_EXIST_LINE_NAME);
                throw new IllegalArgumentException();
            }
        }
    }

    public static void existStationName(Line line, String stationName) {
        for (String name : line.getStationsIncludedLine()) {
            if (name.equals(stationName)) {
                return;
            }
        }
        OutputView.printError(line.getName() + OutputView.MESSAGE_ERROR_NOT_EXIST_STATION_NAME_IN_LINE);
        throw new IllegalArgumentException();
    }

    public static Station existStationName(String stationName) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        OutputView.printError(OutputView.MESSAGE_ERROR_NOT_EXIST_STATION_NAME);
        throw new IllegalArgumentException();
    }

    public static void notIncludedAnyLinesIn(Station station) {
        if (station.includedInSomeLines()) {
            OutputView.printError(OutputView.MESSAGE_ERROR_UNDELETABLE_STATION_NAME);
            throw new IllegalArgumentException();
        }
    }

    public static Line existLineName(String lineName) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName)) {
                return  line;
            }
        }
        OutputView.printError(OutputView.MESSAGE_ERROR_NOT_EXIST_LINE_NAME);
        throw new IllegalArgumentException();
    }

    public static void notIncludedAnyStationsIn(Line line) {
        if (line.includedInSomeStations()) {
            OutputView.printError(OutputView.MESSAGE_ERROR_UNDELETABLE_LINE_NAME);
            throw new IllegalArgumentException();
        }
    }

    public static void compareTerminalName(String northbound, String southbound) {
        if (northbound.equals(southbound)) {
            OutputView.printError(OutputView.MESSAGE_ERROR_SAME_NORTHBOUND_NAME);
            throw new IllegalArgumentException();
        }
    }

    public static void sectionOrderIn(Line line, int order) {
        if (order < 0) {
            OutputView.printError(OutputView.MESSAGE_ERROR_NOT_POSITIVE_INTEGER);
            throw new IllegalArgumentException();
        }
        if (line.getLineLength() < order) {
            OutputView.printError(OutputView.MESSAGE_ERROR_OUT_OF_LINE_RANGE);
            throw new IllegalArgumentException();
        }
    }

    public static void deletableSection(String lineName) {
        if (LineRepository.getLineNamed(lineName).getLineLength() <= NUM_MIN_STATION) {
            OutputView.printError(OutputView.MESSAGE_ERROR_TOO_LITTLE_STATIONS);
            throw new IllegalArgumentException();
        }
    }

}
