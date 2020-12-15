package subway.domain.constants;

public class DomainErrorMessage {
    public static final String EXISTED_ON_LINES = "[ERROR] 해당 역은 노선에 등록되어 있습니다.";
    public static final String EXISTED_ON_INTERVAL = "[ERROR] 해당 구간에 이미 등록되어 있습니다.";
    public static final String LINE_LENGTH = "[ERROR] 노선의 이름은 2글자 이상이어야 합니다.";
    public static final String LINE_FORMAT = "[ERROR] 노선의 이름은 선으로 끝나야 합니다.";
    public static final String MINIMUM_STATION = "[ERROR] 역은 최소 2개 이상이어야 합니다.";
    public static final String NO_CONTAIN_STATION = "[ERROR] 존재하지 않는 역 이름입니다.";
    public static final String NO_CONTAIN_LINE = "[ERROR] 존재하지 않는 노선 이름입니다.";
    public static final String NO_EXISTED_ON_INTERVAL = "[ERROR] 해당 구간에 존재하지 않습니다.";
    public static final String STATION_FORMAT = "[ERROR] 역의 이름은 역으로 끝나야합니다.";
    public static final String STATION_LENGTH = "[ERROR] 역의 이름은 2글자 이상이어야 합니다.";
    public static final String OUT_ORDER = "[ERROR] 범위를 벗어나는 순서입니다.";
    public static final String OVERLAP_LINE = "[ERROR] 이미 등록된 노선입니다.";
    public static final String OVERLAP_STATION = "[ERROR] 이미 등록된 역입니다.";
}
