package subway.line.dto;

public class LineRequestDto {

    private String name;
    private String upstreamStationName;
    private String downstreamStationName;

    public LineRequestDto(String name, String upstreamStationName,
        String downstreamStationName) {
        this.name = name;
        this.upstreamStationName = upstreamStationName;
        this.downstreamStationName = downstreamStationName;
    }

    public String getName() {
        return name;
    }

    public String getUpstreamStationName() {
        return upstreamStationName;
    }

    public String getDownstreamStationName() {
        return downstreamStationName;
    }
}
