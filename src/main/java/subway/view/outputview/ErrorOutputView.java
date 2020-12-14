package subway.view.outputview;

import static subway.view.outputview.OutputView.*;

public class ErrorOutputView {
    private static final String ERROR_SYMBOL = "\n[ERROR] ";
    private static final String INVALID_MENU = "선택할 수 없는 기능입니다.\n";

    public static void invalidMenu() {
        stringBuilder.append(ERROR_SYMBOL);
        stringBuilder.append(INVALID_MENU);
        print();
    }
}
