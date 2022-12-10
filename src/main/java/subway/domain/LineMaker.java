package subway.domain;

public class LineMaker {

    public static Line make(String lineName) {
        return new Line(lineName);
    }
}
