package subway.domain;

public class Line {
    public static int NAME_LENGTH_MIN = 2;
    
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean nameEquals(String name) {
        return this.name.equals(name);
    }
}
