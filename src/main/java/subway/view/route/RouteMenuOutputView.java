package subway.view.route;

public class RouteMenuOutputView {

    private static final String ROUTE_MENU = "## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기\n";
    private static final String CHOOSE_COMMAND_MESSAGE = "## 원하는 기능을 선택하세요.";

    public static void printRouteMenu() {
        System.out.println();
        System.out.println(ROUTE_MENU);
        printChooseCommandMessage();
    }

    public static void printChooseCommandMessage() {
        System.out.println(CHOOSE_COMMAND_MESSAGE);
    }
}
