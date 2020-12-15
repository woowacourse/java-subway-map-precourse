package subway.domain;

public class Line {
    private String name;
    private String ascendingEndPoint;
    private String descendingEndPoint;

    public Line(String name, String ascendingEndPoint, String descendingEndPoint) {
        this.name = name;
        this.ascendingEndPoint = ascendingEndPoint;
        this.descendingEndPoint = descendingEndPoint;
    }

    public String getName() {
        return name;
    }

    // 異붽� 湲곕뒫 援ы쁽
}
