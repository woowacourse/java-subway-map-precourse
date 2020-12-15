package subway.controller;

import subway.controller.constants.ControllerErrorMessage;
import subway.controller.constants.QuestionNumber;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.viewer.IntervalInputViewer;
import subway.viewer.IntervalOutputViewer;

import java.util.Scanner;

public enum IntervalOptions {
    ADD(QuestionNumber.ONE.getOption()) {
        public void processUnit(Scanner scanner) {
            String lineTitle = getLineTitle(scanner);
            String stationTitle = getStationTitle(scanner);
            int order = getOrder(scanner, lineTitle);
            insertInterval(lineTitle, stationTitle, order);
            IntervalOutputViewer.showEnrollInterval();
        }
    },
    DELETE(QuestionNumber.TWO.getOption()) {
        public void processUnit(Scanner scanner) {
            String lineTitle = getLineTitle(scanner);
            String stationTitle = getStationTitle(scanner);
            deleteInterval(lineTitle, stationTitle);
            IntervalOutputViewer.showDeleteInterval();
        }
    },
    BACK(QuestionNumber.BACK.getOption()) {
        public void processUnit(Scanner scanner) {
        }
    };

    private String option;

    IntervalOptions(String option) {
        this.option = option;
    }

    abstract public void processUnit(Scanner scanner);

    public String getOption() {
        return option;
    }

    private static String getLineTitle(Scanner scanner) {
        IntervalInputViewer.askEnrollLine();
        String lineTitle = scanner.next();
        if (!LineRepository.isExistedLine(lineTitle)) {
            System.out.println(ControllerErrorMessage.NO_EXIST_LINE);
            throw new IllegalArgumentException(ControllerErrorMessage.NO_EXIST_LINE);
        }
        return lineTitle;
    }

    private static String getStationTitle(Scanner scanner) {
        IntervalInputViewer.askEnrollStation();
        String stationTitle = scanner.next();
        if (!StationRepository.isExistedStation(stationTitle)) {
            System.out.println(ControllerErrorMessage.NO_EXIST_STATION);
            throw new IllegalArgumentException(ControllerErrorMessage.NO_EXIST_STATION);
        }
        return stationTitle;
    }

    private static int getOrder(Scanner scanner, String lineTitle) {
        IntervalInputViewer.askEnrollOrder();
        String orderString = scanner.next();
        checkInteger(orderString);
        int order = Integer.parseInt(orderString);
        LineRepository.checkOutOrder(lineTitle, order);
        return order;
    }

    private static void insertInterval(String lineTitle, String stationTitle, int order) {
        LineRepository.insertStationToLine(lineTitle, stationTitle, order);
    }

    private static void deleteInterval(String lineTitle, String stationTitle) {
        LineRepository.deleteStationToLine(lineTitle, stationTitle);
    }

    private static void checkInteger(String order) {
        try {
            Integer.parseInt(order);
        } catch (Exception e) {
            System.out.println(ControllerErrorMessage.NO_INTEGER);
            throw new IllegalArgumentException(ControllerErrorMessage.NO_INTEGER);
        }
    }
}
