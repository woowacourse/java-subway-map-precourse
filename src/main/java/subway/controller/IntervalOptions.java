package subway.controller;

import subway.controller.constants.QuestionNumber;
import subway.domain.LineRepository;
import subway.viewer.IntervalInputViewer;
import subway.viewer.IntervalOutputViewer;

import java.util.Scanner;

public enum IntervalOptions {
    ADD(QuestionNumber.ONE.getOption()) {
        public void processUnit(Scanner scanner) {
            String lineTitle = getLineTitle(scanner);
            String stationTitle = getStationTitle(scanner);
            int order = getOrder(scanner);
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
        return scanner.next();
    }

    private static String getStationTitle(Scanner scanner) {
        IntervalInputViewer.askEnrollStation();
        return scanner.next();
    }

    private static int getOrder(Scanner scanner) {
        IntervalInputViewer.askEnrollOrder();
        String orderString = scanner.next();
        return Integer.parseInt(orderString);
    }

    private static void insertInterval(String lineTitle, String stationTitle, int order) {
        LineRepository.insertStationToLine(lineTitle, stationTitle, order);
    }

    private static void deleteInterval(String lineTitle, String stationTitle) {
        LineRepository.deleteStationToLine(lineTitle, stationTitle);
    }
}
