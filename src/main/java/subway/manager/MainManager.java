package subway.manager;

import utils.Power;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

enum MainButton {
    STATION_MANAGER("1"), LINE_MANAGER("2"), SECTION_MANAGER("3"), PRINT_TOTAL_MAP("4"), EXIT_PROGRAM("Q");

    private final String symbol;

    MainButton(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

public class MainManager {

    private static final List<String> choices = Arrays.asList(
            MainButton.STATION_MANAGER.getSymbol(),
            MainButton.LINE_MANAGER.getSymbol(),
            MainButton.SECTION_MANAGER.getSymbol(),
            MainButton.PRINT_TOTAL_MAP.getSymbol(),
            MainButton.EXIT_PROGRAM.getSymbol()
    );

    public static void execute() {
        OutputView.printMain();
        String command = InputView.getFunctionSelect(choices);
        nextProcedure(command);
    }

    public static void nextProcedure(String command) {
        if (command.equals(MainButton.EXIT_PROGRAM.getSymbol())) {
            Power.off();
            OutputView.printInformation(OutputView.EXIT_PROGRAM);
            return;
        }
        if (command.equals(MainButton.STATION_MANAGER.getSymbol())) {
            StationManager.execute();
        }
        if (command.equals(MainButton.LINE_MANAGER.getSymbol())) {
            LineManager.execute();
        }
        if (command.equals(MainButton.SECTION_MANAGER.getSymbol())) {
            SectionManager.execute();
        }
        if (command.equals(MainButton.PRINT_TOTAL_MAP.getSymbol())) {
            OutputView.printTotalMap();
        }
        if (!Power.isOn()) {
            return;
        }
        MainManager.execute();
    }

}
