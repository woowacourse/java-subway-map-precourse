package subway.Manager;

import subway.domain.LineRepository;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class LineManager {
    private static final String LINE_INSERT = "1";
    private static final String LINE_DELETE = "2";
    private static final String LINE_LOOKUP = "3";

    private LineRepository lineRepository;
    private final Scanner scanner;

    public LineManager(Scanner scanner) {
        lineRepository = new LineRepository();
        this.scanner = scanner;
    }

    public void execute(String input) {
        if (input.equals(LINE_INSERT)) {
            createLine();
            OutputView.lineInsertSuccess();
        }
        if (input.equals(LINE_DELETE)) {
            InputView.inputDeleteLine(scanner);
            OutputView.lineDeleteSuccess();
        }
        if (input.equals(LINE_LOOKUP)) {
            OutputView.lineLookup(lineRepository.toString());
        }
    }

    private void createLine() { // 노선 만들기위한 정보 초기화
        String lineName = InputView.inputLineName(scanner);
        String upTerminal = InputView.inputUpTerminalStation(scanner);
        String downTerminal = InputView.inputDownTerminalStation(scanner);
        LineRepository.createLineAndStation(lineName, upTerminal, downTerminal);
    }
}
