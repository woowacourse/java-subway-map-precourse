package subway.domain.constants;

public class DomainErrorMessage {
    public static final String LINE_LENGTH_ERROR_MESSAGE = "[ERROR] 노선의 이름은 2글자 이상이어야 합니다.";
    public static final String MINIMUM_STATION_ERROR = "[ERROR] 역은 최소 2개 이상이어야 합니다.";
    public static final String STATION_LENGTH_ERROR_MESSAGE = "[ERROR] 역의 이름은 2글자 이상이어야 합니다.";
    public static final String OVERLAP_LINE_ERROR = "[ERROR] 노선의 이름이 중복이 되었습니다.";
    public static final String OVERLAP_STATION_ERROR = "[ERROR] 역의 이름이 중복이 되었습니다.";
}
