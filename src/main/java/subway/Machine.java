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
        // TODO "2" - 노선 관리
        // TODO "3" - 구간 관리
        // TODO "4" - 지하철 노선도 출력
        // TODO "Q" - 종료
    }

    public Functions selectMainFunctions(String mainFunctionsNumber) {
        System.out.println("selectMainFunctions : " + mainFunctionsNumber);
        System.out.println(mainFunctions.get(mainFunctionsNumber));
        return mainFunctions.get(mainFunctionsNumber);
    }
}
