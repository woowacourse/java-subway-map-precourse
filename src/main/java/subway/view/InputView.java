package subway.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String INVALID_FUNCTION_ERROR_MESSAGE = "선택할 수 없는 기능입니다.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInputFunctionIndex(List<String> functionIndexList){
        return validateInputFunctionIndex(functionIndexList, scanner.nextLine());
    }

    public String validateInputFunctionIndex(List<String> functionIndexList, String functionIndex) {
        if (!functionIndexList.contains(functionIndex)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + INVALID_FUNCTION_ERROR_MESSAGE);
        }
        return functionIndex;
    }
}
