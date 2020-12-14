package validator;

public class ExceptionMessage {
    public static final String IS_NOT_VALID_FUNCTION = "[ERROR] 선택할 수 없는 기능입니다";
    public static final String STATION_NAME_OVER_TWO = "[ERROR] 역 이름은 2글자 이상이여야 합니다.";
    public static final String STATION_NAME_EXISTS = "[ERROR] 이미 등록된 역 이름입니다.";
    public static final String STATION_IS_IN_LINE = "[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.";
    public static final String NOT_EXIST_DELETE_STATION = "[ERROR] 삭제할 역이 존재하지 않습니다.";
    public static final String LINE_NAME_OVER_TWO = "[ERROR] 노선 이름은 2글자 이상이여야 합니다.";
    public static final String LINE_NAME_EXISTS = "[ERROR] 이미 등록된 노선 이름입니다.";
    public static final String NOT_EXIST_LINE = "[ERROR] 노선이 존재하지 않습니다.";
    public static final String NOT_EXIST_STATION = "[ERROR] 역이 존재하지 않습니다.";
    public static final String SAME_STATION_IN_LINE = "[ERROR] 노선에 같은 역이 존재합니다";
    public static final String NOT_VALID_ORDER = "[ERROR] 넣을 수 없는 구간 순서 입니다";
    public static final String DO_NOT_DELETE_SECTION = "[ERROR] 노선에 구간이 2개 이하 이므로 구간을 삭제할 수 없습니다.";
}
