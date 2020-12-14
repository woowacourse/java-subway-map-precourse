package subway.view.component;

public class ErrorViewComponent {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String UNSELECTABLE_FEATURE = "선택할 수 없는 기능입니다.";
    private static final String DUPLICATED_STATION_NAME = "이미 등록된 역 이름입니다.";
    private static final String STATION_NOT_EXISTED = "존재하지 않는 역 이름입니다.";
    private static final String DUPLICATED_LINE_NAME = "이미 등록된 노선 이름입니다.";
    private static final String STATION_NAME_LENGTH = "역 이름은 2글자 이상이어야 합니다.";
    private static final String DUPLICATED_START_AND_END_STATION_NAME = "시작점과 도착점이 동일합니다.";
    private static final String LINE_NOT_EXIST = "존재하지 않는 노선 이름입니다.";
    private static final String INVALID_POSITION = "노선에서 선택할 수 없는 위치입니다.";
    private static final String MINIMUM_LINE_LENGTH = "노선의 길이가 2보다 작아지게 됩니다.";
    private static final String ALREADY_ADDED_IN_LINE = "노선에 이미 등록된 역은 삭제가 불가능합니다.";
    private static final String STATION_NOT_EXIST_IN_LINE = "해당 노선에 존재하지 않는 역 이름입니다.";

    public static String getUnselectableFeature() {
        return ERROR_PREFIX + UNSELECTABLE_FEATURE;
    }

    public static String getDuplicatedStationName() {
        return ERROR_PREFIX + DUPLICATED_STATION_NAME;
    }

    public static String getStationNotExisted() {
        return ERROR_PREFIX + STATION_NOT_EXISTED;
    }

    public static String getDuplicatedLineName() {
        return ERROR_PREFIX + DUPLICATED_LINE_NAME;
    }

    public static String getDuplicatedStartAndEndStationName() {
        return ERROR_PREFIX + DUPLICATED_START_AND_END_STATION_NAME;
    }

    public static String getStationNameLength() {
        return ERROR_PREFIX + STATION_NAME_LENGTH;
    }

    public static String getLineNotExist() {
        return ERROR_PREFIX + LINE_NOT_EXIST;
    }

    public static String getInvalidPosition() {
        return ERROR_PREFIX + INVALID_POSITION;
    }

    public static String getMinimumLineLength() {
        return ERROR_PREFIX + MINIMUM_LINE_LENGTH;
    }

    public static String getAlreadyAddedInLine() {
        return ERROR_PREFIX + ALREADY_ADDED_IN_LINE;
    }

    public static String getStationNotExistInLine() {
        return ERROR_PREFIX + STATION_NOT_EXIST_IN_LINE;
    }
}
