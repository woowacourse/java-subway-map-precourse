package subway.view.component;

public class StationManagementViewComponent {
    private static final String menuComponent = "## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기";

    public static String getMenuComponent(){
        return menuComponent;
    }
}
