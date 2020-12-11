package subway.enums;

public enum StationInfo {
    INFO("[INFO] "),

    ASK_STATION_NAME_TO_REGISTER("## 등록할 역 이름을 입력하세요."),
    INFO_STATION_REGISTERED(INFO.getInfo() + "지하철 역이 등록되었습니다."),

    ASK_STATION_NAME_TO_DELETE("## 삭제할 역 이름을 입력하세요."),
    INFO_STATION_DELETED(INFO.getInfo() + "지하철 역이 삭제되었습니다."),

    STATION_LIST("## 역 목록");

    String info = "";

    StationInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
