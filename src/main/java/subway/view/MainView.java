package subway.view;

public class MainView {
    private static final String mainView = "## 메인 화면\n" +
            "1. 역 관리\n" +
            "2. 노선 관리\n" +
            "3. 구간 관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료\n";

    public static void printMainView(){
        System.out.println(mainView);
    }
}
