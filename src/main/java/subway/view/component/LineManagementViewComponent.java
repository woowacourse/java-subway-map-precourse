package subway.view.component;

public class LineManagementViewComponent {
    private static final String menuComponent = "## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기";

    public static String getMenuComponent(){
        return menuComponent;
    }
}
