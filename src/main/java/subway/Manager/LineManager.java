package subway.Manager;

import Category.Category;
import subway.Service.LineService;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class LineManager {
    private static final String LINE_INSERT = "1";
    private static final String LINE_DELETE = "2";
    private static final String LINE_LOOKUP = "3";

    private static final Scanner scanner = new Scanner(System.in);
    private static LineService lineService;

    static {
        lineService = new LineService();
    }

    public static void execute() { // 노선 관리 실행
        OutputView.functionView(Category.LINE.getName(), Category.LINE.getActionOrder());
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
