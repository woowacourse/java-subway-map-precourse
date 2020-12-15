package subway.controller;

import subway.controller.constants.ControllerErrorMessage;
import subway.controller.constants.QuestionNumber;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.viewer.IntervalInputViewer;
import subway.viewer.IntervalOutputViewer;

import java.util.Scanner;

public enum IntervalSectors {
    ADD(QuestionNumber.ONE.getOption()) {
        public void processUnit(Scanner scanner) {
            IntervalInputViewer.askEnrollLine();
            String lineTitle = getLineTitle(scanner);
            IntervalInputViewer.askEnrollStation();
            String stationTitle = getStationTitle(scanner);
            int order = getOrder(scanner, lineTitle);
            LineRepository.insertStationToLine(lineTitle, stationTitle, order);
            IntervalOutputViewer.showEnrollInterval();
        }
    },
    DELETE(QuestionNumber.TWO.getOption()) {
        public void processUnit(Scanner scanner) {
            IntervalInputViewer.deleteLine();
            String lineTitle = getLineTitle(scanner);
            IntervalInputViewer.deleteStation();
            String stationTitle = getStationTitle(scanner);
            LineRepository.deleteStationToLine(lineTitle, stationTitle);
            IntervalOutputViewer.showDeleteInterval();
        }
    },
    BACK(QuestionNumber.BACK.getOption()) {
        public void processUnit(Scanner scanner) {}
    };

    private String option;

    private IntervalSectors(String option) {
        this.option = option;
    }

    abstract public void processUnit(Scanner scanner);

    public String getOption() {
        return option;
    }

    private static String getLineTitle(Scanner scanner) {
        String lineTitle = scanner.nextLine();
        if (!LineRepository.isExistedLine(lineTitle)) {
            System.out.println(ControllerErrorMessage.NO_EXIST_LINE);
            throw new IllegalArgumentException(ControllerErrorMessage.NO_EXIST_LINE);
        }
        return lineTitle;
    }

    private static String getStationTitle(Scanner scanner) {
        String stationTitle = scanner.nextLine();
        if (!StationRepository.isExistedStation(stationTitle)) {
            System.out.println(ControllerErrorMessage.NO_EXIST_STATION);
            throw new IllegalArgumentException(ControllerErrorMessage.NO_EXIST_STATION);
        }
        return stationTitle;
    }

    private static int getOrder(Scanner scanner, String lineTitle) {
        IntervalInputViewer.askEnrollOrder();
        String orderString = scanner.nextLine();
        checkInteger(orderString);
        int order = Integer.parseInt(orderString);
        LineRepository.checkOutOrder(lineTitle, order);
        return order;
    }

    private static void checkInteger(String order) {
        try {
            Integer.parseInt(order);
        } catch (Exception error) {
            System.out.println(ControllerErrorMessage.NO_INTEGER);
            throw new IllegalArgumentException(ControllerErrorMessage.NO_INTEGER);
        }
    }
}
