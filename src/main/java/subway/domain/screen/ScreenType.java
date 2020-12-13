package subway.domain.screen;

public enum ScreenType {
    MAIN, STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT, SUBWAY_MAP_PRINT, EXIT;

    public boolean isMainScreen() {
        return equals(MAIN);
    }

    public boolean isStationManagementScreen() {
        return equals(STATION_MANAGEMENT);
    }

    public boolean isLineManagementScreen() {
        return equals(LINE_MANAGEMENT);
    }

    public boolean isSectionManagementScreen() {
        return equals(SECTION_MANAGEMENT);
    }

    public boolean isSubwayMapPrintScreen() {
        return equals(SUBWAY_MAP_PRINT);
    }

    public boolean isExitScreen() {
        return equals(EXIT);
    }
}
