package subway.domain.input;

import subway.domain.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainInput {

    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_THREE = "3";
    static final String FUNCTION_FOUR = "4";
    static final String FUNCTION_QUIT = "Q";

    List<String> functionList = new ArrayList<>();

    private List<String> functionList() {
        functionList.add(FUNCTION_ONE);
        functionList.add(FUNCTION_TWO);
        functionList.add(FUNCTION_THREE);
        functionList.add(FUNCTION_FOUR);
        functionList.add(FUNCTION_QUIT);
        return Collections.unmodifiableList(functionList);
    }

    public String inputMainScreen(Scanner scanner) throws IllegalArgumentException {
        String mainChoice = scanner.next();
        if (functionList().contains(mainChoice)) {
            return mainChoice;
        }
        ErrorMessage.isInvalidFunction();
        throw new IllegalArgumentException();
    }

}
