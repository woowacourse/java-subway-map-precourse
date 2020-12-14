package subway.maintain;

import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.LineRepository;
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
        OutputView.deleteLineName();
        if(!LineRepository.deleteLineByName(scanner.next())){
            ErrorView.notExistName();
            maintainPage();
        }
        OutputView.completeDeleteLine();
        new Controller(scanner);
    }

    private void registerLine() {
        OutputView.writeLineName();
        Line line = new Line(scanner.next());
        if(line.getName() == null){
            ErrorView.nameLengthError();
            maintainPage();
            return;
        }
        registerStation(line);
    }

    private void registerStation(Line line) {
        OutputView.writeStartStation();
        if(!line.addStation(scanner.next())){
            maintainPage();
            return;
        }
        OutputView.writeEndStation();
        if(!line.addStation(scanner.next())){
            maintainPage();
            return;
        }
        LineRepository.addLine(line);
        OutputView.completeRegisterLine();
        new Controller(scanner);
    }


}
