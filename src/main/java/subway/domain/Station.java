package subway.domain;

public class Station {
    public static int NAME_LENGTH_MIN = 2;
    
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean nameEquals(String name) {
        return this.name.equals(name);
    }
}
