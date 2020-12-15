package subway.maintain;

import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.utils.Util;
import subway.view.ErrorView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineMaintain {
    private static final int START = 1;
    private static final int END = 3;
    private static final int BACK_PAGE = 0;
    private static final int ERROR = -1;
    private static final int REGISTER_LINE = 1;
    private static final int DELETE_LINE = 2;
    private static final int LINE_STATUS = 3;


    private final Scanner scanner;

    public LineMaintain(Scanner scanner) {
        this.scanner = scanner;
        maintainPage();
    }

    private void maintainPage() {
        OutputView.lineMaintain();
        control();
    }

    private void control() {
        OutputView.writeOperation();
        int operationNumber = Util.operationNumber(scanner.next(), START, END);
        movePage(operationNumber, scanner);
    }

    private void movePage(int operationNumber, Scanner scanner) {
        if (operationNumber == BACK_PAGE) {
            new Controller(scanner);
        }
        if (operationNumber == ERROR) {
            maintainPage();
        }
        if (operationNumber == REGISTER_LINE) {
            registerLine();
        }
        if (operationNumber == DELETE_LINE) {
            deleteLine();
        }
        if (operationNumber == LINE_STATUS) {
            lineStatus();
        }
    }

    private void lineStatus() {
        OutputView.lineStatus();
        LineRepository.lineStatus();
        new Controller(scanner);
    }

    private void deleteLine() {
        OutputView.deleteLineName();
        if (!LineRepository.deleteLineByName(scanner.next())) {
            ErrorView.notExistName();
            maintainPage();
        }
        OutputView.completeDeleteLine();
        new Controller(scanner);
    }

    private void registerLine() {
        OutputView.writeLineName();
        Line line = new Line(scanner.next());
        if (line.getName() == null) {
            ErrorView.nameLengthError();
            maintainPage();
            return;
        }
        if(LineRepository.isDuplicateLine(line.getName())){
            ErrorView.duplicateName();
            maintainPage();
            return;
        }
        registerStation(line);
    }

    private void registerStation(Line line) {
        OutputView.writeStartStation();
        if (!line.addStation(scanner.next())) {
            maintainPage();
            return;
        }
        OutputView.writeEndStation();
        if (!line.addStation(scanner.next())) {
            maintainPage();
            return;
        }
        LineRepository.addLine(line);
        OutputView.completeRegisterLine();
        new Controller(scanner);
    }


}
