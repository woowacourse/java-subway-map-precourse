package subway.exception.input;

import java.util.List;

import subway.exception.CustomException;
import subway.view.OutputView;

public class InputExceptionHandler {

    protected static final String UNSELECTABLE_ERROR = "선택할 수 없는 기능입니다.\n";

    protected static boolean contains(String contained, List<String> container) {
        return container.contains(contained);
    }

    protected static void unselectableError() {
        try {
            throw new CustomException(UNSELECTABLE_ERROR);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
