package subway.view;

public class ErrorView {
    public static final String LABEL = "[ERROR] ";
    public static final String DECISION_NOT_NUMERIC = LABEL + "선택할 수 없는 기능입니다.";
    public static final String DECISION_OUT_OF_RANGE = LABEL + "선택할 수 없는 기능입니다.";
    public static final String NAME_SHORT = LABEL + "이름의 길이가 너무 짧습니다";
    public static final String NAME_DUPLICATE = LABEL + "중복되는 이름이 있습니다.";
    public static final String NAME_ELEMENT = LABEL + "이름은 공백을 포함하지 않은 한글 또는 숫자로 이루어져야 합니다.";
    public static final String STATION_DELETE_FAIL = LABEL + "해당 역은 노선에 연결되어 지울 수 없습니다.";
    public static final String STATION_NOTHING = LABEL + "해당 역은 존재하지 않습니다.";
    public static final String STATION_NO_CONNECTION = LABEL + "해당 역은 노선에 존재하지 않습니다.";
    public static final String STATION_ENDING = LABEL + "역의 이름은 '역'으로 끝나야합니다.";
    public static final String LINE_MINIMAL_STATIONS = LABEL + "해당 노선은 종착역으로만 이루어져 있습니다.";
    public static final String LINE_STATION_DUPLICATE = LABEL + "역이 이미 노선에 등록되어 있습니다.";
    public static final String LINE_NOTHING = LABEL + "해당 노선은 존재하지 않습니다.";
    public static final String LINE_ENDING = LABEL + "노선의 이름은 '선'으로 끝나야합니다.";
    public static final String INDEX_INVALID = LABEL + "유효하지 않은 순서입니다.";
}
