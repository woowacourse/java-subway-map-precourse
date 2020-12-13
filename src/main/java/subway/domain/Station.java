package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isEqual(String name){
        if(this.name.compareTo(name) ==0) return true;
        return false;
    }
}
