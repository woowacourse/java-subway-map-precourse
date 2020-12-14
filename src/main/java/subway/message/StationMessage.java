package subway.message;

public enum StationMessage {
    CHOICE_STATION_OPTION_LIST("## 원하는 기능을 선택하세요."),
    ;

    private final String text;

    StationMessage(String text) {
        this.text = text;
    }

    public String getStationMessage() {
        return this.text;
    }

}
