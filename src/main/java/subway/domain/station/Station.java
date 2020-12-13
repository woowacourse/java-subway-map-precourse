package subway.domain.station;

public class Station {
    private String name;
    private boolean isPathEnrolled = false;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public void onPath() {
        isPathEnrolled = true;
    }

    public boolean isOnPath() {
        return isPathEnrolled;
    }
}
