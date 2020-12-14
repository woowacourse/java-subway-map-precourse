package subway.domain.station;

public class Station {
    private String name;
    private int isPathEnrolled = 0;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public void addOnPath() {
        isPathEnrolled += 1;
    }

    public void deleteOnPath(){
        isPathEnrolled -= 1;
    }

    public boolean isAvailableToDelete() {
        return isPathEnrolled == 0;
    }
}
