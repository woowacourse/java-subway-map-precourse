package subway.type;

public enum InformationType {
    INFORMATION("[INFO] "),
    STATION_ADDING_INFORMATION(INFORMATION.getInformation() + "지하철 역이 등록되었습니다."),
    STATION_DELETION_INFORMATION(INFORMATION.getInformation() + "지하철 역이 삭제되었습니다."),
    LINE_ADDING_INFORMATION(INFORMATION.getInformation() + "지하철 노선이 등록되었습니다."),
    LINE_DELETION_INFORMATION(INFORMATION.getInformation() + "지하철 노선이 삭제되었습니다.");

    private final String information;

    InformationType(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }
}
