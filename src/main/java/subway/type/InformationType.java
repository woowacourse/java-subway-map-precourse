package subway.type;

/**
 * InformationType.java : 실행 결과 문구 상수를 모아둔 Enum 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public enum InformationType {
    INFORMATION("[INFO] "),

    STATION_ADDITION_INFORMATION(INFORMATION.getInformation() + "지하철 역이 등록되었습니다."),
    STATION_DELETION_INFORMATION(INFORMATION.getInformation() + "지하철 역이 삭제되었습니다."),

    LINE_ADDITION_INFORMATION(INFORMATION.getInformation() + "지하철 노선이 등록되었습니다."),
    LINE_DELETION_INFORMATION(INFORMATION.getInformation() + "지하철 노선이 삭제되었습니다."),

    SECTION_ADDITION_INFORMATION(INFORMATION.getInformation() + "구간이 등록되었습니다."),
    SECTION_DELETION_INFORMATION(INFORMATION.getInformation() + "구간이 삭제되었습니다.");

    private final String information;

    InformationType(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }
}
