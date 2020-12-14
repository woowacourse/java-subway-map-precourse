package subway.Manager;

import subway.Service.LineService;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class LineManager {
    private static final String LINE_MAIN = "\n## 노선 관리 화면";
    private static final String LINE_FUNCTION = "1. 노선 등록\n" + "2. 노선 삭제\n" + "3. 노선 조회\n" + "B. 돌아가기";

    private static final String LINE_INSERT = "1";
    private static final String LINE_DELETE = "2";
    private static final String LINE_LOOKUP = "3";

    private static final Scanner scanner = new Scanner(System.in);
    private static LineService lineService;

    static {
        lineService = new LineService();
    }

    public static void execute() { // 노선 관리 실행
        OutputView.functionView(LINE_MAIN, LINE_FUNCTION);
        String input = InputView.inputLineFunction(scanner);

        if (input.equals(LINE_INSERT)) {
            lineService.createLine(InputView.inputLineInfo(scanner));
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
