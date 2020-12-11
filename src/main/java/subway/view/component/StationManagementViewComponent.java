package subway.view.component;

public class StationManagementViewComponent {
    private static final String menuComponent = "## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기";
    private static final String finishPrefixComponent ="[INFO] ";
    private static final String registerStationComponent = "## 등록할 역 이름을 입력하세요.";
    private static final String registerStationFinishComponent = "지하철 역이 등록되었습니다.";
    private static final String removeStationComponent ="## 삭제할 역 이름을 입력하세요.";
    private static final String removeStationFinishComponent = "지하철 역이 삭제되었습니다.";

    public static String getMenuComponent(){
        return menuComponent;
    }

    public static String getFinishPrefixComponent() {
        return finishPrefixComponent;
    }

    public static String getRegisterStationComponent(){
        return registerStationComponent;
    }

    public static String getRegisterStationFinishComponent(){
        return finishPrefixComponent + registerStationFinishComponent;
    }

    public static String getRemoveStationComponent(){
        return removeStationComponent;
    }

    public static String getRemoveStationFinishComponent(){
        return finishPrefixComponent + removeStationFinishComponent;
    }
}
