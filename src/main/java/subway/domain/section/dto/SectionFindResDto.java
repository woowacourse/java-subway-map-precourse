package subway.domain.section.dto;

public class SectionFindResDto {
    private String lineName;

    public SectionFindResDto(String lineName) {
        this.lineName = lineName;
    }

    public String getLineName() {
        return lineName;
    }
}
