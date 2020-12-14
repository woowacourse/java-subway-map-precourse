package subway.maintain;

import subway.controller.Controller;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Util;
import subway.view.ErrorView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationMaintain {
    private static final int START = 1;
    private static final int END = 3;
    private static final int BACK_PAGE = 0;
    private static final int REGISTER_STATION = 1;
    private static final int DELETE_STATION = 2;
    private static final int STATION_STATUS = 3;
    private static final int ERROR = -1;

    private final Scanner scanner;

    public StationMaintain(Scanner scanner) {
        this.scanner = scanner;
        maintainPage();
    }

    private void maintainPage() {
        OutputView.stationMaintain();
        control();
    }

    private void control() {
        OutputView.writeOperation();
        int operationNumber = Util.operationNumber(scanner.next(), START, END);
        movePage(operationNumber, scanner);
    }

    private void movePage(int operationNumber, Scanner scanner) {
        if (operationNumber == ERROR) {
            maintainPage();
        }
        if (operationNumber == BACK_PAGE) {
            new Controller(scanner);
        }
        if (operationNumber == REGISTER_STATION) {
            registerStation();
        }
        if (operationNumber == DELETE_STATION) {
            deleteStation();
        }
        if (operationNumber == STATION_STATUS) {
            stationStatus();
        }
    }

    private void stationStatus() {
        OutputView.stationStatus();
        StationRepository.status();
        new Controller(scanner);
    }

    private void deleteStation() {
        OutputView.deleteStationName();
        String name = scanner.next();
        if (LineRepository.lineRegisterStation(name)) {
            ErrorView.lineRegisterStation();
            maintainPage();
            return;
        }
        if (!StationRepository.deleteStation(name)) {
            ErrorView.notExistName();
            maintainPage();
            return;
        }
        OutputView.completeDeleteStation();
        new Controller(scanner);

    }

    private void registerStation() {
        OutputView.writeStationName();
        if (StationRepository.addStation(new Station(scanner.next()))) {
            OutputView.completeRegisterStation();
            new Controller(scanner);
            return;
        }
        maintainPage();
    }
}
