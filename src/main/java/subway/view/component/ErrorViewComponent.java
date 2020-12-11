package subway.view.component;

public class ErrorViewComponent {
    private static final String errorPrefixComponent = "[ERROR] ";
    private static final String unselectableFeatureComponent = "선택할 수 없는 기능입니다.";
    private static final String duplicatedStationNameComponent = "이미 등록된 역 이름입니다.";
    private static final String stationNotExistComponent = "존재하지 않는 역 이름입니다.";

    public static String getUnselectableFeatureComponent(){
        return errorPrefixComponent + unselectableFeatureComponent;
    }

    public static String getDuplicatedStationNameLog(){
        return errorPrefixComponent + duplicatedStationNameComponent;
    }

    public static String getStationNotExistComponent(){
        return errorPrefixComponent + stationNotExistComponent;
    }
}
