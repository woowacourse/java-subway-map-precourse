package subway.controller;

import subway.utils.Util;
import subway.view.OutputView;

import java.util.Scanner;

public class Controller {
    private static final int START = 1;
    private static final int END = 4;
    private static Scanner scanner;

    public Controller(Scanner scanner) {
        this.scanner = scanner;
        mainPage();
    }


    public void mainPage(){
        OutputView.mainPage();
        control();
    }

    private void control() {
        OutputView.writeOperation();
        int operationNumber = Util.operationNumber(scanner.next(),START,END);
        movePage(operationNumber,scanner);
    }

    private void movePage(int operationNumber,Scanner scanner) {
        if(operationNumber == -1){
            control();
        }
        if(operationNumber == 1){

        }
        if(operationNumber == 2){

        }
        if(operationNumber == 3){

        }
        if(operationNumber == 4){

        }
    }
}
