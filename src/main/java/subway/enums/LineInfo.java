package subway.enums;

public enum LineInfo {
    INFO("[INFO] "),

    ASK_LINE_NAME_TO_REGISTER("## 등록할 노선 이름을 입력하세요."),
    ASK_UP_LAST_STATION("## 등록할 노선의 상행 종점역 이름을 입력하세요."),
    ASK_DOWN_LAST_STATION("## 등록할 노선의 하행 종점역 이름을 입력하세요."),
    INFO_LINE_REGISTERED(INFO.getInfo() + "지하철 노선이 등록되었습니다."),

    ASK_LINE_NAME_TO_DELETE("## 삭제할 노선 이름을 입력하세요."),
    INFO_LINE_DELETED(INFO.getInfo() + "지하철 노선이 삭제되었습니다."),

    LINE_LIST("## 노선 목록");

    String info = "";

    LineInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
