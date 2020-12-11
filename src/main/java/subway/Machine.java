package subway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import subway.domain.function.Functions;
import subway.domain.function.FunctionsFactory;
import subway.view.InputView;

public class Machine {

    private HashMap<String, Functions> mainFunctions = new HashMap<>();

    public Machine() {
        mainFunctions.put("1", FunctionsFactory.createStationFunctions());
        mainFunctions.put("2", FunctionsFactory.createLineFunction());
        mainFunctions.put("3", FunctionsFactory.createSectionFunctions());
        mainFunctions.put("4", FunctionsFactory.createStationFunctions());
    }

    public Functions selectMainFunctions(String mainFunctionsNumber) {
        return mainFunctions.get(mainFunctionsNumber);
    }
}
