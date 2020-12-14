package subway.view.component;

public class ErrorViewComponent {
    private static final String errorPrefixComponent = "[ERROR] ";
    private static final String unselectableFeatureComponent = "선택할 수 없는 기능입니다.";
    private static final String duplicatedStationNameComponent = "이미 등록된 역 이름입니다.";
    private static final String stationNotExistComponent = "존재하지 않는 역 이름입니다.";
    private static final String duplicatedLineNameComponent = "이미 등록된 노선 이름입니다.";
    private static final String stationNameLengthComponent = "역 이름은 2글자 이상이어야 합니다.";
    private static final String duplicatedStartAndEndStationNameComponent = "시작점과 도착점이 동일합니다.";
    private static final String lineNotExistComponent = "존재하지 않는 노선 이름입니다.";
    private static final String invalidPositionComponent = "노선에서 선택할 수 없는 위치입니다.";
    private static final String minimumLineLengthComponent = "노선의 길이가 2보다 작아지게 됩니다.";
    private static final String alreadyAddedInLineComponent = "노선에 이미 등록된 역은 삭제가 불가능합니다.";
    private static final String stationNotExistInLineComponent = "해당 노선에 존재하지 않는 역 이름입니다.";

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

    public static String getStationNameLengthComponent(){
        return errorPrefixComponent + stationNameLengthComponent;
    }

    public static String getLineNotExistComponent(){
        return errorPrefixComponent + lineNotExistComponent;
    }

    public static String getInvalidPositionComponent(){
        return errorPrefixComponent + invalidPositionComponent;
    }

    public static String getMinimumLineLengthComponent(){
        return errorPrefixComponent + minimumLineLengthComponent;
    }

    public static String getAlreadyAddedInLineComponent(){
        return errorPrefixComponent + alreadyAddedInLineComponent;
    }

    public static String getStationNotExistInLineComponent(){
        return errorPrefixComponent + stationNotExistInLineComponent;
    }
}
