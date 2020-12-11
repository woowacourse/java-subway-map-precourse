package subway.dto;

public class StationDTO implements DTO {
    private final String name;

    public StationDTO(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
