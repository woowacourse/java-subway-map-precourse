package subway.controller;

import subway.view.Error;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    protected static final String MENU_ONE = "1";
    protected static final String MENU_TWO = "2";
    protected static final String MENU_THREE = "3";
    protected static final String MENU_BACK = "B";
    protected static final List<String> PRIMARY_FUNCTIONS = Arrays
            .asList(MENU_ONE, MENU_TWO, MENU_THREE, MENU_BACK);

    protected Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        do {
            info();
        } while (managing(scanner.nextLine()));
    }

    protected abstract void info();

    // 유효 입력 여과
    protected boolean managing(String choice) {
        if (PRIMARY_FUNCTIONS.contains(choice)) {
            return executeFunction(choice);
        }
        Error.noFunction();
        return true;
    }

    // true -> 반복, false -> 종료
    protected boolean executeFunction(String choice) {
        if (choice.equals(MENU_ONE)) {
            return !functionOne();
        }
        if (choice.equals(MENU_TWO)) {
            return !functionTwo();
        }
        if (choice.equals(MENU_THREE)) {
            return !functionThree();
        }
        return false;
    }

    protected boolean functionOne() {
        return false;
    }

    protected boolean functionTwo() {
        return false;
    }

    protected boolean functionThree() {
        return false;
    }
}
