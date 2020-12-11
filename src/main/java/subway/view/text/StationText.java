package subway.view.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StationText {
    private static String FUNCTION_TITLE = "역 관리 화면";
    private static List<String> FUNCTION_INDEX_LIST = new ArrayList<>(Arrays.asList(
            "1",
            "2",
            "3",
            "B"
    ));
    private static List<String> FUNCTION_LIST = new ArrayList<>(Arrays.asList(
            "1. 역 등록",
            "2. 역 삭제",
            "3. 역 조회",
            "B. 돌아가기"
    ));

    private StationText() {
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
