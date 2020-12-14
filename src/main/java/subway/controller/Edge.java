package subway.controller;

import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.exception.NonExistentNameException;
import subway.domain.exception.IncludeInLineException;
import subway.domain.exception.OrderRangeException;
import subway.domain.exception.OrderTypeException;
import subway.domain.exception.MinimumStationNumberException;
import subway.domain.exception.NotIncludeInLineException;

public class Edge {
    private static final String STATION_MESSAGE = "역";
    private static final String LINE_MESSAGE = "노선";
    private static final int MINIMUM_DELETE_CONDITION_STAION_NUMBER = 3;
    private Edge() {
    }

    public static void add(InputView inputView) {
        String lineName = scanLineName(inputView);
        String stationName = scanStationName(inputView, lineName);
        int order = scanOrder(inputView, lineName);
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            Line line = LineRepository.lines().get(i);
            if (line.getName().equals(lineName)) {
                line.addStationByName(stationName);
            }
        }
        OutputView.printAddActionFinishMessage(LINE_MESSAGE);
    }

    public static void delete(InputView inputView) {
        OutputView.printDeleteEdgeOptionMessage(LINE_MESSAGE);
        String lineName = inputView.getInput();
        validateLineState(lineName);
        OutputView.printDeleteEdgeOptionMessage(STATION_MESSAGE);
        String stationName = inputView.getInput();
        validateStationState(stationName, lineName);
    }

    private static void validateLineState(String lineName) {
        Line.validateExistentLineName(lineName, LINE_MESSAGE);
        if (Line.validateRange(MINIMUM_DELETE_CONDITION_STAION_NUMBER)) {
            throw new MinimumStationNumberException();
        }
    }

    private static void validateStationState(String stationName, String lineName) {
        if (StationRepository.validateNewName(stationName)) {
            throw new NonExistentNameException(STATION_MESSAGE);
        }
        if (!validateLineIncludeStation(lineName, stationName)) {
            throw new NotIncludeInLineException();
        }
    }

    private static String scanLineName(InputView inputView) {
        OutputView.printInputMessage(LINE_MESSAGE);
        String lineName = inputView.getInput();
        Line.validateExistentLineName(lineName, LINE_MESSAGE);
        return lineName;
    }

    private static String scanStationName(InputView inputView, String lineName) {
        OutputView.printInputMessage(STATION_MESSAGE);
        String stationName = inputView.getInput();
        validateStationName(lineName, stationName);
        return stationName;
    }

    private static int scanOrder(InputView inputView, String lineName) {
        OutputView.printOrderInputMessage();
        String order = inputView.getInput();
        validateOrder(order, lineName);
        return Integer.parseInt(order);
    }

    private static void validateStationName(String lineName, String stationName) {
        if (StationRepository.validateNewName(stationName)) {
            throw new NonExistentNameException(STATION_MESSAGE);
        }
        if (validateLineIncludeStation(lineName, stationName)) {
            throw new IncludeInLineException();
        }
    }

    private static boolean validateLineIncludeStation(String lineName, String stationName) {
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            Line line = LineRepository.lines().get(i);
            if (line.getName().equals(lineName)) {
                return !line.validateNewName(stationName);
            }
        }
        return false;
    }

    private static void validateOrder(String order, String lineName) {
        if (!validateOrderType(order)) {
            throw new OrderTypeException();
        }
        int orderNumber = Integer.parseInt(order);
        if (!validateOrderRange(orderNumber, lineName)) {
            throw new OrderRangeException();
        }
    }

    private static boolean validateOrderType(String order) {
        try {
            int orderNumber = Integer.parseInt(order);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    private static boolean validateOrderRange(int order, String lineName) {
        if (!validateOrderPositiveNumber(order)) {
            return false;
        }
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            Line line = LineRepository.lines().get(i);
            if (line.getName().equals(lineName)) {
                return line.validateRange(order);
            }
        }
        return false;
    }

    private static boolean validateOrderPositiveNumber(int order) {
        if (order <= 0) {
            return false;
        }
        return true;
    }
}
