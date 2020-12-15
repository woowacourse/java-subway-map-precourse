package subway.domain.constants;

public class DomainErrorMessage {
    public static final String ENTIRE_MINIMUM_STATION = "[ERROR] 해당 역 삭제시 역이 부족한 노선이 발생합니다.";
    public static final String LINE_LENGTH = "[ERROR] 노선의 이름은 2글자 이상이어야 합니다.";
    public static final String LINE_FORMAT = "[ERROR] 노선의 이름은 선으로 끝나야 합니다.";
    public static final String MINIMUM_STATION = "[ERROR] 역은 최소 2개 이상이어야 합니다.";
    public static final String NO_CONTAIN_STATION = "[ERROR] 존재하지 않는 역 이름입니다.";
    public static final String NO_CONTAIN_LINE = "[ERROR] 존재하지 않는 노선 이름입니다.";
    public static final String STATION_FORMAT = "[ERROR] 역의 이름은 역으로 끝나야합니다.";
    public static final String STATION_LENGTH = "[ERROR] 역의 이름은 2글자 이상이어야 합니다.";
    public static final String OUT_ORDER = "[ERROR] 범위를 벗어나는 순서입니다.";
    public static final String OVERLAP_LINE = "[ERROR] 노선의 이름이 중복이 되었습니다.";
    public static final String OVERLAP_STATION = "[ERROR] 역의 이름이 중복이 되었습니다.";
}
