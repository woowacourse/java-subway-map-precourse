package subway.screen;

public enum ScreenType {
    MAIN("메인 화면"),
    STATION_MANAGEMENT("역 관리 화면"),
    LINE_MANAGEMENT("노선 관리 화면"),
    ROUTE_MANAGEMENT("구간 관리 화면");
    
    String screenName;
    
    ScreenType(String screenName) {
        this.screenName = screenName;
    }
    
    public String toString() {
        return screenName;
    }
}
