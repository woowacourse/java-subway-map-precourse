package subway.domain;

public class Station {
    private Name name;


    public Station(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }
}
