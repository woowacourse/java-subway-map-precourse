package subway.message;

public enum LineMessage {
    LINE_FUNCTION_LIST("## 노선 관리 화면\n"
        + "1. 노선 등록\n"
        + "2. 노선 삭제\n"
        + "3. 노선 조회\n"
        + "B. 돌아가기"),
    LINE_ADD_GUIDE("## 등록할 노선 이름을 선택하세요."),
    LINE_UPTERMINUS_ADD_GUIDE("## 등록할 노선의 상행 종점역 이름을 입력하세요."),
    LINE_DOWNTERMINUS_ADD_GUIDE("## 등록할 노선의 하행 종점역 이름을 입력하세요."),
    
    LINE_ADD_SUCCESS("[INFO] 지하철 노선이 등록되었습니다."),

    LINE_NAME_DUPLICATION_ERROR("[ERROR] 노선 이름은 중복될 수 없습니다."),
    LINE_ADD_STATION_NAME_FAIL("[ERROR] 역 이름을 올바르게 입력해 주세요."),
    LINE_ADD_LIMIT_FAIL("[ERROR] 노선 이름은 2글자 이상이여야 합니다."),
    LINE_TWO_NAME_SAME_ERROR("[ERROR] 상행 종착역과 하행 종착역의 이름은 달라야 합니다.")
    ;


    private final String text;

    LineMessage(String text) {
        this.text = text;
    }

    public String getLineMessage() {
        return this.text;
    }

}
