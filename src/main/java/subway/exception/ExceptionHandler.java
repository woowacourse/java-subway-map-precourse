package subway.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.view.OutputView;

public class ExceptionHandler {

    public static void unselectable(String selection, String[] pattern) {
        List<String> patternList = new ArrayList<>(Arrays.asList(pattern));
        try {
            if (patternList.contains(selection)) {
                return;
            }
            throw new CustomException("선택할 수 없는 기능입니다.");
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
