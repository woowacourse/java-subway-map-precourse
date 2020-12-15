package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    private int count = 0;

    public void increaseCount() {
        this.count++;
    }

    public void decreaseCount() {
        this.count--;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isRemovable() {
        if (this.count == 0) {
            return true;
        }
        return false;
    }
}
