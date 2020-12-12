package subway.view;

public class OutputView {
    private static final String MAIN_CONTROLLER_INFORMATION = "## 메인 화면\n1. 역관리\n2. 노선관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String STATION_CONTROLLER_INFORMATION = "## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기\n";

    private static final String GIVE_OPTION = "## 원하는 기능을 선택하세요.";

    public static void optionInstruction() {
        System.out.println(GIVE_OPTION);
    }

    public static void printMainControllerOption () {
        System.out.println(MAIN_CONTROLLER_INFORMATION);
    }

    public static void printStationControllerOption () {
        System.out.println(STATION_CONTROLLER_INFORMATION);
    }
}
