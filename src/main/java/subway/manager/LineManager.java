package subway.manager;

import subway.domain.Line;
import subway.domain.LineRepository;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

enum LineButton {
    REGISTER("1"), DELETE("2"), INQUIRY("3"), BACK("B");

    private final String symbol;

    LineButton(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

public class LineManager {

    private static final List<String> choices = Arrays.asList(
            LineButton.REGISTER.getSymbol(),
            LineButton.DELETE.getSymbol(),
            LineButton.INQUIRY.getSymbol(),
            LineButton.BACK.getSymbol()
    );

    public static void execute() {
        OutputView.printLineManagement();
        String command = InputView.getFunctionSelect(choices);
        nextProcedure(command);
    }

    public static void nextProcedure(String command) {
        if (command.equals(LineButton.BACK.getSymbol())) {
            MainManager.execute();
            return;
        }
        if (command.equals(LineButton.REGISTER.getSymbol())) {
            registerLine();
        }
        if (command.equals(LineButton.DELETE.getSymbol())) {
            deleteLine();
        }
        if (command.equals(LineButton.INQUIRY.getSymbol())) {
            OutputView.printTotalLine();
        }
        MainManager.execute();
    }

    public static void registerLine() {
        String lineName = InputView.getRegisterLineName();
        String northboundName = InputView.getRegisterLineNorthboundName();
        String southboundName = InputView.getRegisterLineSouthboundName(northboundName);
        LineRepository.addLine(new Line(lineName, northboundName, southboundName));
        OutputView.printInformation(OutputView.MESSAGE_SUCCESS_REGISTER_LINE);
    }

    public static void deleteLine() {
        if (LineRepository.isEmpty()) {
            OutputView.printError(OutputView.MESSAGE_ERROR_EMPTY_LINE_REPOSITORY);
            return;
        }
        String lineName = InputView.getDeleteLineName();
        LineRepository.deleteLineByName(lineName);
        OutputView.printInformation(OutputView.MESSAGE_SUCCESS_DELETE_LINE);
    }

}
