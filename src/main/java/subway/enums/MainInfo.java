package subway.enums;

public enum MainInfo {
    INFO("[INFO] "),

    INPUT("## 원하는 기능을 선택하세요."),
    EXIT(INFO.getInfo() + "프로그램을 종료합니다.");

    String info = "";

    MainInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
