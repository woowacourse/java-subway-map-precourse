package subway.view.component;

public class LineManagementViewComponent {
    private static final String menuComponent = "## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기";
    private static final String finishPrefixComponent ="[INFO] ";
    private static final String lineRegisterComponent = "## 등록할 노선 이름을 입력하세요.";
    private static final String stationRequiringBeginComponent = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String stationRequiringEndComponent = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String registerFinishComponent = "지하철 노선이 등록되었습니다.";
    private static final String removeLineBeginComponent = "## 삭제할 노선 이름을 입력하세요.";
    private static final String removeLineFinishComponent = "지하철 노선이 삭제되었습니다.";
    private static final String subwayLineMapLog = "## 지하철 노선도";

    public static String getMenuComponent(){
        return menuComponent;
    }

    public static String getLineRegisterComponent(){
        return lineRegisterComponent;
    }

    public static String getStationRequiringBeginComponent(){
        return stationRequiringBeginComponent;
    }

    public static String getStationRequiringEndComponent(){
        return stationRequiringEndComponent;
    }

    public static String getRegisterFinishComponent(){
        return finishPrefixComponent + registerFinishComponent;
    }

    public static String getRemoveLineBeginComponent(){
        return removeLineBeginComponent;
    }

    public static String getRemoveLineFinishComponent(){
        return finishPrefixComponent + removeLineFinishComponent;
    }

    public static String getSubwayLineMapLog(){
        return subwayLineMapLog;
    }
}
