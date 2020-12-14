package subway.Manager;

import subway.Service.LineService;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class LineManager {
    private static final String LINE_INSERT = "1";
    private static final String LINE_DELETE = "2";
    private static final String LINE_LOOKUP = "3";

    private LineService lineService;
    private final Scanner scanner;

    public LineManager(Scanner scanner) {
        lineService = new LineService(scanner);
        this.scanner = scanner;
    }

    public void execute(String input) { // 노선 관리 실행
        if (input.equals(LINE_INSERT)) {
            lineService.createLine();
            OutputView.lineInsertSuccess();
        }
        if (input.equals(LINE_DELETE)) {
            lineService.deleteLine(InputView.inputDeleteLineName(scanner));
            OutputView.lineDeleteSuccess();
        }
        if (input.equals(LINE_LOOKUP)) {
            OutputView.linesPrint(lineService.lineLookup());
        }
    }
}
