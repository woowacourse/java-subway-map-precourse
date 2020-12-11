package subway;

import subway.constant.Information;
import subway.exception.InvalidInputException;

import java.util.Scanner;

public class Manager {

    private Scanner scanner;
    private FunctionValidator functionValidator = new FunctionValidator();
    private boolean isContinue = true;

    public Manager(Scanner scanner) {
        this.scanner = scanner;
    }


    public void start() {
        initParams();
        while (isContinue)
            runFunction();
    }

    private void initParams() {
        // TODO 노선도 초기화
    }

    private void runFunction() {
        try {
            String selectedFunction = selectFunction();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private String selectFunction() throws InvalidInputException {
        String line = getFunctionInput();
        functionValidator.validate(line);
        return line;
    }

    private String getFunctionInput() {
        System.out.println(Information.MAIN_INFO);
        return scanner.nextLine();
    }
}
