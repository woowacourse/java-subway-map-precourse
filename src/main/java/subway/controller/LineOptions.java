package subway.controller;

import subway.controller.constants.QuestionNumber;
import subway.controller.constants.StationOrderConstants;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.viewer.LineInputViewer;
import subway.viewer.LineOutputViewer;

import java.util.Scanner;

public enum LineOptions {
    ADD(QuestionNumber.ONE.getOption()) {
        public void processUnit(Scanner scanner) {
            enrollLine(scanner);
            LineOutputViewer.showEnrollLine();
        }
    },
    DELETE(QuestionNumber.TWO.getOption()) {
        public void processUnit(Scanner scanner) {
            deleteLine(scanner);
            LineOutputViewer.showDeleteLine();
        }
    },
    CHECK(QuestionNumber.THREE.getOption()) {
        public void processUnit(Scanner scanner) {
            LineOutputViewer.showLineList(LineRepository.lines());
        }
    },
    BACK(QuestionNumber.BACK.getOption()) {
        public void processUnit(Scanner scanner) {
        }
    };

    private String option;

    LineOptions(String option) {
        this.option = option;
    }

    abstract public void processUnit(Scanner scanner);

    public String getOption() {
        return option;
    }

    private static void enrollLine(Scanner scanner) {
        LineInputViewer.askEnrollLine();
        String lineTitle = getValidatedLine(scanner);
        LineInputViewer.askDepartureStation();
        String departure = getValidatedStation(scanner);
        LineInputViewer.askTerminalStation();
        String terminal = getValidatedStation(scanner);
        insertLine(lineTitle, departure, terminal);
    }

    private static String getValidatedLine(Scanner scanner) {
        String lineTitle = scanner.next();
        LineRepository.checkOverlappedLine(lineTitle);
        return lineTitle;
    }

    private static String getValidatedStation(Scanner scanner) {
        String stationTitle = scanner.next();
        StationRepository.checkOverlappedStation(stationTitle);
        return stationTitle;
    }

    private static void insertLine(String lineTitle, String departure, String terminal) {
        int initialLocation = StationOrderConstants.INITIAL.getLocation();
        int terminalLocation = StationOrderConstants.TERMINAL.getLocation();
        Line line = new Line(lineTitle);
        line.insertStation(initialLocation, new Station(departure));
        line.insertStation(terminalLocation, new Station(terminal));
    }

    private static void deleteLine(Scanner scanner) {
        LineInputViewer.askDeleteLine();
        String stationTitle = scanner.next();
        LineRepository.deleteLineByName(stationTitle);
    }
}
