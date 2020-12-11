package subway.view.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineText {
    private static String FUNCTION_TITLE = "노선 관리 화면";
    private static List<String> FUNCTION_INDEX_LIST = new ArrayList<>(Arrays.asList(
            "1",
            "2",
            "3",
            "B"
    ));
    private static List<String> FUNCTION_LIST = new ArrayList<>(Arrays.asList(
            "1. 노선 등록",
            "2. 노선 삭제",
            "3. 노선 조회",
            "B. 돌아가기"
    ));

    private LineText() {
    }

    public static String getFunctionTitle() {
        return FUNCTION_TITLE;
    }

    public static List<String> getFunctionIndexList() {
        return FUNCTION_INDEX_LIST;
    }

    public static List<String> getFunctionList() {
        return FUNCTION_LIST;
    }
}
