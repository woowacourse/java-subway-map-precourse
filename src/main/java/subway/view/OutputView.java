package subway.view;

public class OutputView {

    private static final String MAIN_PAGE = "## 메인화면\n" +
            "1. 역 관리\n" +
            "2. 노선관리\n" +
            "3. 구간관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료\n";
    private static final String STATION_MAINTAIN = "## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기\n";
    private static final String LINE_MAINTAIN = "## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기\n";
    private static final String SECTION_MAINTAIN = "## 구간 관리 화면\n" +
            "1. 구간 등록\n" +
            "2. 구간 삭제\n" +
            "B. 돌아가기\n";
    private static final String WRITE_OPERATION = "## 원하는 기능을 선택하세요.";

    public static void print(String string){
        System.out.println(string);
    }

    public static void mainPage(){
        print(MAIN_PAGE);
    }

    public static void writeOperation(){
        print(WRITE_OPERATION);
    }

}
