package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.exception.IncludeInLineException;
import subway.domain.exception.MinimumStationNumberException;
import subway.domain.exception.NonExistentNameException;
import subway.domain.exception.NotIncludeInLineException;
import subway.domain.exception.OrderRangeException;
import subway.domain.exception.OrderTypeException;
import subway.view.InputView;
import subway.view.OutputView;

public class Edge {
    private static final String STATION_MESSAGE = "역";
    private static final String LINE_MESSAGE = "노선";
    private static final String EDGE_MESSAGE = "구간";
    private static final String NAME_MESSAGE = "이름";
    private static final int ORDER_INDEX_CONSTANT = 1;
    private static final int MINIMUM_DELETE_CONDITION_STAION_NUMBER = 3;

    private Edge() {
    }

    public static void add(InputView inputView) {
        String lineName = scanAddEdgeLineName(inputView);
        String stationName = scanAddEdgeStationName(inputView, lineName);
        int order = scanOrder(inputView, lineName);
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            Line line = LineRepository.lines().get(i);
            if (line.getName().equals(lineName)) {
                line.addStationByName(stationName, order);
            }
        }
        OutputView.printEdgeAddActionFinishMessage(EDGE_MESSAGE);
    }

    public static void delete(InputView inputView) {
        String lineName = scanDeleteEdgeLineName(inputView);
        String stationName = scanDeleteEdgeStationName(inputView, lineName);
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            Line line = LineRepository.lines().get(i);
            if (line.getName().equals(lineName)) {
                line.deleteStationByName(stationName);
            }
        }
        OutputView.printEdgeDeleteActionFinishMessage(EDGE_MESSAGE);
    }

    private static void validateLineState(String lineName) {
        Line.validateExistentLineName(lineName, LINE_MESSAGE);
        validateLineRange(lineName);
    }

    private static void validateLineRange(String lineName) {
        boolean isValidRange = false;
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            Line line = LineRepository.lines().get(i);
            if (line.getName().equals(lineName)) {
                isValidRange = line.validateRange(MINIMUM_DELETE_CONDITION_STAION_NUMBER);
            }
        }
        if (!isValidRange) {
            throw new MinimumStationNumberException();
        }
    }

    private static void validateStationState(String stationName, String lineName) {
        if (StationRepository.validateUniqueName(stationName)) {
            throw new NonExistentNameException(STATION_MESSAGE);
        }
        if (!validateLineIncludeStation(lineName, stationName)) {
            throw new NotIncludeInLineException();
        }
    }

    private static String scanAddEdgeLineName(InputView inputView) {
        OutputView.printInputMessage(LINE_MESSAGE);
        String lineName = inputView.getInput();
        Line.validateExistentLineName(lineName, LINE_MESSAGE);
        return lineName;
    }

    private static String scanAddEdgeStationName(InputView inputView, String lineName) {
        String stationNameMessage = STATION_MESSAGE + NAME_MESSAGE;
        OutputView.printInputMessage(stationNameMessage);
        String stationName = inputView.getInput();
        validateStationName(lineName, stationName);
        return stationName;
    }

    private static String scanDeleteEdgeLineName(InputView inputView) {
        OutputView.printDeleteEdgeOptionMessage(LINE_MESSAGE);
        String lineName = inputView.getInput();
        validateLineState(lineName);
        return lineName;
    }

    private static String scanDeleteEdgeStationName(InputView inputView, String lineName) {
        OutputView.printDeleteEdgeOptionMessage(STATION_MESSAGE);
        String stationName = inputView.getInput();
        validateStationState(stationName, lineName);
        return stationName;
    }

    private static int scanOrder(InputView inputView, String lineName) {
        OutputView.printOrderInputMessage();
        String order = inputView.getInput();
        validateOrder(order, lineName);
        return Integer.parseInt(order);
    }

    private static void validateStationName(String lineName, String stationName) {
        if (StationRepository.validateUniqueName(stationName)) {
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
                return !line.validateLineIncludeStation(stationName);
            }
        }
        return false;
    }

    private static void validateOrder(String order, String lineName) {
        if (!validateOrderType(order)) {
            throw new OrderTypeException();
        }
        int orderNumber = Integer.parseInt(order);
        if ((!validateOrderPositiveNumber(orderNumber)) || (!validateOrderRange(orderNumber, lineName))){
            throw new OrderRangeException();
        }
    }

    private static boolean validateOrderType(String order) {
        try {
            Integer.parseInt(order);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    private static boolean validateOrderRange(int order, String lineName) {
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            Line line = LineRepository.lines().get(i);
            if (line.getName().equals(lineName)) {
                int orderIndex = order - ORDER_INDEX_CONSTANT;
                return line.validateRange(orderIndex);
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
