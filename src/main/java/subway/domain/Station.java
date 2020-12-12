package subway.domain;

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

    public void onAndOffPath(){
        isPathEnrolled = !isPathEnrolled;
    }
    public boolean isOnPath(){
        return isPathEnrolled;
    }
}
