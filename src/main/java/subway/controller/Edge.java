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

public class Edge {
    private static final String STATION_MESSAGE = "역";
    private static final String LINE_MESSAGE = "노선";
    private static final String NAME_MESSAGE = "이름";
    private Edge() {
    }

    public static void add(InputView inputView) {
        OutputView.printInputMessage(LINE_MESSAGE);
        String lineName = inputView.getInput();
        Line.validateExistentLineName(lineName, LINE_MESSAGE);

        OutputView.printInputMessage(STATION_MESSAGE);
        String stationName = inputView.getInput();
        validateStationName(lineName, stationName);

        OutputView.printOrderInputMessage();
        String order = inputView.getInput();
        validateOrder(order, lineName);
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
