package subway.controller.enums;

public enum ModeType {
    STATION_MANAGEMENT_MODE("1"),
    LINE_MANAGEMENT_MODE("2"),
    SECTION_MANAGEMENT_MODE("3"),
    PRINT_MODE("4");

    private String mode;

    ModeType(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}