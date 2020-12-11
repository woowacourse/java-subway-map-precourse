package subway.view.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SectionText {
    private static String FUNCTION_TITLE = "구간 관리 화면";
    private static List<String> FUNCTION_INDEX_LIST = new ArrayList<>(Arrays.asList(
            "1",
            "2",
            "B"
    ));
    private static List<String> FUNCTION_LIST = new ArrayList<>(Arrays.asList(
            "1. 구간 등록",
            "2. 구간 삭제",
            "B. 돌아가기"
    ));

    private SectionText() {
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
