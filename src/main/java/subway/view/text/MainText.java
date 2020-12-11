package subway.view.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainText {
    private static String FUNCTION_TITLE = "메인 화면";
    private static List<String> FUNCTION_INDEX_LIST = new ArrayList<>(Arrays.asList(
            "1",
            "2",
            "3",
            "4",
            "Q"
    ));
    private static List<String> FUNCTION_LIST = new ArrayList<>(Arrays.asList(
            "1. 역 관리",
            "2. 노선 관리",
            "3. 구간 관리",
            "4. 지하철 노선도 출력",
            "Q. 종료"
    ));

    private MainText() {
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
