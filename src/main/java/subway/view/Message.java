package subway.view;

import java.util.Arrays;
import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class Message {
    private static final List<String> mainMenus = Arrays.asList("## 메인 화면",
            "1. 역 관리",
            "2. 노선 관리",
            "3. 구간 관리",
            "4. 지하철 노선도 출력",
            "Q. 종료");

    private static final List<String> stationMenus = Arrays.asList(
            "\n## 역 관리 화면",
            "1. 역 등록",
            "2. 역 삭제",
            "3. 역 조회",
            "B. 돌아가기");

    private static final String selectFeature = "\n## 원하는 기능을 선택하세요.";

    private Message() {
    }

    public static void printMainMenu() {
        mainMenus.forEach(System.out::println);
        System.out.println(selectFeature);
    }

    public static void printStatinMenu() {
        stationMenus.forEach(System.out::println);
        System.out.println(selectFeature);
    }

    public static void printLine() {
        System.out.println();
    }
}
