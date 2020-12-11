package subway.manager;

import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class StationManager {

    private static final List<String> choices = Arrays.asList("1", "2", "3", "B");

    public static void execute() {
        OutputView.printStationManagement();
        String command = InputView.getFunctionSelect(choices);
        nextProcedure(command);
    }

    public static void nextProcedure(String command) {
        // 다른 manager execute 호출
    }

}
