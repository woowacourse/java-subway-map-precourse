package subway.domain;

public class Line {
    private String name;
    private String firstStation;
    private String lastStation;

    public Line(String name, String firstStation, String lastStation) {
        this.name = name;
        this.firstStation = firstStation;
        this.lastStation = lastStation;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
