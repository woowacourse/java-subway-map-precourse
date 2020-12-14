package subway.domain;

public class Station {
    private String name;
    private Line line = null; //역은 line 정보를 가진다.

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isStationhasLine(){
        if (line != null){
            return true;
        }
        return false;
    }
}
