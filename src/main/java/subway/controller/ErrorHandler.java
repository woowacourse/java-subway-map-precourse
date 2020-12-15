package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Objects;
import java.util.regex.Pattern;

public class ErrorHandler {
    private static final String STATION_NAME_END = "역";
    private static final String LINE_NAME_END = "선";
    private static final int NAME_MIN_LENGTH = 2;
    private static final int LENGTH_TO_INDEX = 1;

    public static void validateStationNameFormat(String inputData) {
        if (inputData.length() < NAME_MIN_LENGTH
                || !Pattern.matches("^[0-9가-힣]*$", inputData)
                || !inputData.substring(inputData.length() - LENGTH_TO_INDEX).equals(STATION_NAME_END)) {
            throw new IllegalArgumentException("format error");
        }
    }

    public static void validateStationDuplicate(String inputData) {
        if (StationRepository.isDuplicate(inputData)) {
            throw new IllegalArgumentException("duplicate error");
        }
    }

    public static void validateStationRegistered(String inputData) {
        if (!StationRepository.isDuplicate(inputData)) {
            throw new IllegalArgumentException("not registered error");
        }
    }

    public static void validateLineNameFormat(String inputData) {
        if (inputData.length() < NAME_MIN_LENGTH
                || !Pattern.matches("^[0-9가-힣]*$", inputData)
                || !inputData.substring(inputData.length() - LENGTH_TO_INDEX).equals(LINE_NAME_END)) {
            throw new IllegalArgumentException("format error");
        }
    }

    public static void validateLineDuplicate(String inputData) {
        if (LineRepository.isDuplicate(inputData)) {
            throw new IllegalArgumentException("duplicate error");
        }
    }

    public static void validateLineRegistered(String inputData) {
        if (!LineRepository.isDuplicate(inputData)) {
            throw new IllegalArgumentException("not registered error");
        }
    }

    public static void validateStationDuplicateInLine(Station targetStation, Line line) {
        if (line.getSections().stream()
                .anyMatch(station -> Objects.equals(station, targetStation))) {
            throw new IllegalArgumentException("duplicate error");
        }
    }

    public static void validateStationRegisteredInLine(Station targetStation, Line line) {
        if (line.getSections().stream()
                .noneMatch(station -> Objects.equals(station, targetStation))) {
            throw new IllegalArgumentException("not registered error");
        }
    }

    public static void validateOrder(String targetOrder, Line line) {
        int order = Integer.parseInt(targetOrder);
        if (order < 1 || order > line.getSections().size()) {
            throw new IllegalArgumentException("inbound error");
        }
    }

}
