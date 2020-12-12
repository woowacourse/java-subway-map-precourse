package subway.domain.section.dto;

public class SectionDeleteReqDto {
    private String lineName;

    public SectionDeleteReqDto(String lineName) {
        this.lineName = lineName;
    }

    public String getLineName() {
        return lineName;
    }
}
