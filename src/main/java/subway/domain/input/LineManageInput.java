package subway.domain.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LineManageInput {

    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_THREE = "3";
    static final String FUNCTION_BACK = "B";

    List<String> functionList = new ArrayList<>();

    public List<String> functionList() {
        functionList.add(FUNCTION_ONE);
        functionList.add(FUNCTION_TWO);
        functionList.add(FUNCTION_THREE);
        functionList.add(FUNCTION_BACK);
        return Collections.unmodifiableList(functionList);
    }

    public String inputLineManageScreen(Scanner scanner) throws IllegalArgumentException{
        String lineManageChoice = scanner.next();
        if (functionList().contains(lineManageChoice)) {
            return lineManageChoice;
        }
        // 정해진 것만 입력하라는 메시지
        throw new IllegalArgumentException();
    }



}
