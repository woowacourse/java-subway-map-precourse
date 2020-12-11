package subway.service;

import subway.constant.Function;
import subway.exception.InvalidInputException;

import java.util.Scanner;

public abstract class CrudService implements MapService {

    private Scanner scanner;
    private String info;

    public CrudService(Scanner scanner, String info) {
        this.scanner = scanner;
        this.info = info;
    }

    @Override
    public void run() {
        try {
            String selectedFunction = selectFunction();
            runSelectedFunction(selectedFunction);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private String selectFunction() {
        String line = getFunctionInput();
        Function.validate(line);
        return line;
    }

    private String getFunctionInput() {
        System.out.println(info);
        return scanner.nextLine();
    }

    private void runSelectedFunction(String selectedFunction) {
        if (selectedFunction.equals(Function.ADD.getCode()))
            add();
        if (selectedFunction.equals(Function.DELETE.getCode()))
            delete();
        if (selectedFunction.equals(Function.SHOW.getCode()))
            show();
    }

    public abstract void add();

    public abstract void delete();

    public abstract void show();
}
