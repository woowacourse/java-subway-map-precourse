package subway.view.component;

public class ErrorViewComponent {
    private static final String errorPrefixComponent = "[ERROR] ";
    private static final String unselectableFeatureComponent = "선택할 수 없는 기능입니다.";
    private static final String duplicatedStationNameComponent = "이미 등록된 역 이름입니다.";
    private static final String stationNotExistComponent = "존재하지 않는 역 이름입니다.";
    private static final String duplicatedLineNameComponent = "이미 등록된 노선 이름입니다.";
    private static final String duplicatedStartAndEndStationNameComponent = "시작점과 도착점이 동일합니다.";
    private static final String lineNotExistComponent = "존재하지 않는 노선 이름입니다.";

    public static String getUnselectableFeatureComponent(){
        return errorPrefixComponent + unselectableFeatureComponent;
    }

    public static String getDuplicatedStationNameLog(){
        return errorPrefixComponent + duplicatedStationNameComponent;
    }

    public static String getStationNotExistComponent(){
        return errorPrefixComponent + stationNotExistComponent;
    }

    public static String getDuplicatedStationNameComponent(){
        return errorPrefixComponent + duplicatedLineNameComponent;
    }

    public static String getDuplicatedStartAndEndStationNameComponent(){
        return errorPrefixComponent + duplicatedStartAndEndStationNameComponent;
    }

    public static String getLineNotExistComponent(){
        return errorPrefixComponent + lineNotExistComponent;
    }
}
