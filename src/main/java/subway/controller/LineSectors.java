package subway.controller;

import subway.controller.constants.ControllerErrorMessage;
import subway.controller.constants.QuestionNumber;
import subway.controller.constants.StationOrderConstants;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.viewer.LineInputViewer;
import subway.viewer.LineOutputViewer;

import java.util.Scanner;

public enum LineSectors {
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
        public void processUnit(Scanner scanner) {}
    };

    private String option;

    private LineSectors(String option) {
        this.option = option;
    }

    abstract public void processUnit(Scanner scanner);

    public String getOption() {
        return option;
    }

    private static void enrollLine(Scanner scanner) {
        LineInputViewer.askEnrollLine();
        String lineTitle = getValidatedLine(scanner);
        LineRepository.checkOverlappedLine(lineTitle);
        LineInputViewer.askDepartureStation();
        String departure = getValidatedStation(scanner);
        LineInputViewer.askTerminalStation();
        String terminal = getValidatedStation(scanner);
        insertLine(lineTitle, departure, terminal);
    }

    private static String getValidatedLine(Scanner scanner) {
        String lineTitle = scanner.nextLine();
        LineRepository.checkOverlappedLine(lineTitle);
        return lineTitle;
    }

    private static String getValidatedStation(Scanner scanner) {
        String stationTitle = scanner.nextLine();
        if (!StationRepository.isExistedStation(stationTitle)) {
            System.out.println(ControllerErrorMessage.NO_EXIST_STATION);
            throw new IllegalArgumentException(ControllerErrorMessage.NO_EXIST_STATION);
        }
        return stationTitle;
    }

    private static void insertLine(String lineTitle, String departure, String terminal) {
        isSameDepartureTerminal(departure, terminal);
        int departureLocation = StationOrderConstants.INITIAL.getLocation();
        int terminalLocation = StationOrderConstants.TERMINAL.getLocation();
        Line line = new Line(lineTitle);
        line.insertStation(departureLocation, new Station(departure));
        line.insertStation(terminalLocation, new Station(terminal));
        LineRepository.addLine(line);
    }

    private static void isSameDepartureTerminal(String departure, String terminal) {
        if (departure.equals(terminal)) {
            System.out.println(ControllerErrorMessage.SAME_DEPARTURE_TERMINAL);
            throw new IllegalArgumentException(ControllerErrorMessage.SAME_DEPARTURE_TERMINAL);
        }
    }

    private static void deleteLine(Scanner scanner) {
        LineInputViewer.askDeleteLine();
        String lineTitle = scanner.nextLine();
        LineRepository.deleteLineByName(lineTitle);
    }
}
