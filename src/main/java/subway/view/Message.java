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

    private static final List<String> lineMenus = Arrays.asList(
            "## 노선 관리 화면",
            "1. 노선 등록",
            "2. 노선 삭제",
            "3. 노선 조회",
            "B. 돌아가기");

    private static final List<String> sectionMenus = Arrays.asList(
            "\n## 구간 관리 화면",
            "1. 구간 등록",
            "2. 구간 삭제",
            "B. 돌아가기");

    private static final String selectFeature = "\n## 원하는 기능을 선택하세요.";
    private static final String subwayLine = "## 지하철 노선도";
    private static final String error = "\n[ERROR] 선택할 수 없는 기능입니다.";
    private static final String createStation = "\n## 등록할 역 이름을 입력하세요.";
    private static final String successStation = "\n[INFO] 지하철 역이 등록되었습니다.";
    private static final String ERROR_LENGTH_NAME = "\n[ERROR] 이름은 2글자 이상이어야 합니다.";
    private static final String ERROR_NAME = "\n[ERROR] 이름은 역으로 끝나야 합니다.";

    private Message() {
    }

    public static void printMainMenu() {
        mainMenus.forEach(System.out::println);
        printSelectFeature();
    }

    public static void printStatinMenu() {
        stationMenus.forEach(System.out::println);
        printSelectFeature();
    }

    public static void printLineMenu() {
        lineMenus.forEach(System.out::println);
        printSelectFeature();
    }

    public static void printSectionMenu() {
        sectionMenus.forEach(System.out::println);
        printSelectFeature();
    }

    public static void printSubwayLineMessage() {
        System.out.println(subwayLine);
    }

    public static void printSelectFeature() {
        System.out.println(selectFeature);
    }

    public static void printError() {
        System.out.println(error);
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printCreateStation() {
        System.out.println(createStation);
    }

    public static void printSuccessStation() {
        System.out.println(successStation);
    }

    public static void printNameLengthError() {
        System.out.println(ERROR_LENGTH_NAME);
    }

    public static void printNameError() {
        System.out.println(ERROR_NAME);
    }
}
