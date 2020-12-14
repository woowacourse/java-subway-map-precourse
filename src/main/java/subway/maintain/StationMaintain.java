package subway.maintain;

import subway.controller.Controller;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Util;
import subway.view.ErrorView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationMaintain {
    private static final int START = 1;
    private static final int END = 3;
    
    private final Scanner scanner;

    public StationMaintain(Scanner scanner){
        this.scanner = scanner;
        maintainPage();
    }

    private void maintainPage() {
        OutputView.stationMaintain();
        control();
    }

    private void control() {
        OutputView.writeOperation();
        int operationNumber = Util.operationNumber(scanner.next(),START,END);
        movePage(operationNumber,scanner);
    }

    private void movePage(int operationNumber, Scanner scanner) {
        if(operationNumber == 0){
            maintainPage();
        }
        if(operationNumber == 1){
            registerStation();
        }
        if(operationNumber == 2){
            deleteStation();
        }
        if(operationNumber == 3){
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
        if(StationRepository.deleteStation(scanner.next())){
            OutputView.completeDeleteStation();
            new Controller(scanner);
            return;
        }
        ErrorView.notExistName();
        maintainPage();
    }

    private void registerStation() {
        OutputView.writeStationName();
        if(StationRepository.addStation(new Station(scanner.next()))){
            OutputView.completeRegisterStation();
            new Controller(scanner);
            return;
        }
        maintainPage();
    }
}
