package subway.domain.line.dto;

public class LineSaveReqDto {
    private String name;

    public LineSaveReqDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
