package subway.Exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExceptionHandler {

    public static void isUnSelectable(String string, String[] pattern) {
        List<String> patternList = new ArrayList<>(Arrays.asList(pattern));
        if (!patternList.contains(string)) {
            throw new CustomException("선택할 수 없는 기능입니다.");
        }
    }
}
