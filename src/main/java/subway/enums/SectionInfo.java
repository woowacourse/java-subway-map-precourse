package subway.enums;

public enum SectionInfo {
    INFO("[INFO] "),

    ASK_LINE_TO_ENROLL_STATION_ON("## 노선을 입력하세요."),
    ASK_STATION_TO_ENROLL_ON_LINE("## 역이름을 입력하세요."),
    ASK_POSITION_TO_ENROLL_STATION("## 순서를 입력하세요."),
    INFO_SECTION_ENROLLED(INFO.getInfo() + "구간이 등록되었습니다."),

    ASK_LINE_TO_DELETE_STATION_FROM("## 삭제할 구간의 노선을 입력하세요."),
    ASK_STATION_TO_DELETE_FROM_LINE("## 삭제할 구간의 역을 입력하세요."),
    INFO_SECTION_DELETED(INFO.getInfo() + "구간이 삭제되었습니다."),

    SECTION_LIST("## 지하철 노선도");

    String info = "";

    SectionInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
