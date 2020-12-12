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
        } else if (command.equals(LineButton.REGISTER.getSymbol())) {
            registerLine();
        } else if (command.equals(LineButton.DELETE.getSymbol())) {
            deleteLine();
        } else if (command.equals(LineButton.INQUIRY.getSymbol())) {
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
        String lineName = InputView.getDeleteLineName();
        if (LineRepository.deleteLineByName(lineName)) {
            OutputView.printInformation(OutputView.MESSAGE_SUCCESS_DELETE_LINE);
        } else { // ELSE 삭제합시다!!!
            System.out.println("[TEST] 노선 삭제 과정에서 뭔가 잘못됐어요 ~~~");
            System.out.println("[TEST] 아마도 이게 보여질 일은 없을거야~ 아마두~");
        }
    }

}
