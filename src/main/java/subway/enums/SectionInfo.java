package subway.enums;

public enum SectionInfo {
    INFO("[INFO] "),

    ASK_LINE_TO_ENROLL_STATION_ON("## 노선을 입력하세요."),
    ASK_STATION_TO_ENROLL_ON_LINE("## 역이름을 입력하세요."),
    ASK_POSITION_TO_ENROLL_STATION("## 순서를 입력하세요."),
    INFO_SECTION_ENROLLED(INFO.getInfo() + "구간이 등록되었습니다."),

    STATION_LIST("## 역 목록");

    String info = "";

    SectionInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
