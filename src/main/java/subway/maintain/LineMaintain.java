package subway.maintain;

import subway.controller.Controller;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Util;
import subway.view.ErrorView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineMaintain {
    private static final int START = 1;
    private static final int END = 3;

    private final Scanner scanner;

    public LineMaintain(Scanner scanner){
        this.scanner = scanner;
        maintainPage();
    }

    private void maintainPage() {
        OutputView.lineMaintain();
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
            registerLine();
        }
        if(operationNumber == 2){
            deleteLine();
        }
        if(operationNumber == 3){
            lineStatus();
        }
    }

    private void lineStatus() {
    }

    private void deleteLine() {
    }

    private void registerLine() {
    }


}
