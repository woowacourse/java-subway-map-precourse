package subway.domain.command;

public enum MainCommand implements Command {
    STATION_MANAGEMENT("1", "역 관리"),
    LINE_MANAGEMENT("2", "노선 관리"),
    SECTION_MANAGEMENT("3", "구간 관리"),
    SUBWAY_MAP_PRINT("4", "지하철 노선도 출력"),
    EXIT("Q", "종료");

    private final String selector;
    private final String detail;

    MainCommand(String selector, String detail) {
        this.selector = selector;
        this.detail = detail;
    }

    @Override
    public boolean isMatched(String userMessage) {
        return selector.equals(userMessage);
    }

    @Override
    public String toString() {
        return selector + ". " + detail + "\n";
    }
}
