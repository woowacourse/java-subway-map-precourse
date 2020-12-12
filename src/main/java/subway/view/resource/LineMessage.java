package subway.view.resource;

public class LineMessage {
    public static final String SELECT_FUNCTION = "노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기\n";
    public static final String INPUT_LINE_NAME_FOR_REGISTRATION = "등록할 노선 이름을 입력하세요.";
    public static final String INPUT_TOP_STATION = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String INPUT_BOTTOM_STATION = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String INPUT_LINE_NAME_FOR_REMOVAL = "삭제할 노선 이름을 입력하세요.";
    public static final String COMPLETE_REGISTRATION = "지하철 노선이 등록되었습니다.";
    public static final String COMPLETE_REMOVAL = "지하철 노선이 삭제되었습니다.";
    public static final String LINE_LIST = "노선 목록";
}
