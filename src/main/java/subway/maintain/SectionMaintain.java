package subway.maintain;

import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.utils.Util;
import subway.view.ErrorView;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionMaintain {
    private static final int START = 1;
    private static final int END = 2;
    private static final int REGISTER_SECTION = 1;
    private static final int DELETE_SECTION = 2;
    private static final int ERROR = -1;
    private static final int BACK_PAGE = 0;

    private final Scanner scanner;

    public SectionMaintain(Scanner scanner){
        this.scanner = scanner;
        maintainPage();
    }

    private void maintainPage() {
        OutputView.sectionMaintain();
        control();
    }

    private void control() {
        OutputView.writeOperation();
        int operationNumber = Util.operationNumber(scanner.next(),START,END);
        movePage(operationNumber,scanner);
    }

    private void movePage(int operationNumber, Scanner scanner) {
        if(operationNumber == ERROR){
            new Controller(scanner);
        }
        if(operationNumber == BACK_PAGE){
            maintainPage();
        }
        if(operationNumber == REGISTER_SECTION){

        }
        if(operationNumber == DELETE_SECTION){

        }

    }


}
