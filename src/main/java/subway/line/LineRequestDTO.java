package subway.line;

public class LineRequestDTO {
    private String name;
    private String startStation;
    private String endStation;

    public LineRequestDTO(String name, String startStation, String endStation) {
        this.name = name;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public String getName() {
        return name;
    }

    public String getStartStation() {
        return startStation;
    }

    public String getEndStation() {
        return endStation;
    }
}
