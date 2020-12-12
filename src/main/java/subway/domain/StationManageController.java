package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StationManageController {

    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_THREE = "3";
    static final String FUNCTION_BACK = "B";

    Scanner scanner;
    List<String> functionList = new ArrayList<>();

    public List<String> functionList() {
        functionList.add(FUNCTION_ONE);
        functionList.add(FUNCTION_TWO);
        functionList.add(FUNCTION_THREE);
        functionList.add(FUNCTION_BACK);
        return Collections.unmodifiableList(functionList);
    }

    public String inputStationManageScreen(Scanner scanner) throws IllegalArgumentException{
        String stationManageChoice = scanner.next();
        if (functionList().contains(stationManageChoice)) {
            return stationManageChoice;
        }
        throw new IllegalArgumentException();
    }

}
