package subway.domain;

public class Line {
    private String name;
    private Path pathInfo;

    public Line(String name, Station... stations) {
        this.name = name;
        pathInfo = new Path(stations);
    }

    public String getName() {
        return name;
    }

    public Station getUpLine() {
        return pathInfo.getUpLine();
    }

    public Station getDownLine() {
        return pathInfo.getDownLine();
    }
}
