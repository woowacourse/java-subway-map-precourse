package subway.maintain;

import subway.utils.Util;
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
    }

    private void deleteStation() {
    }

    private void registerStation() {
        
    }
}
