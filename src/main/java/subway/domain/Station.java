package subway.domain;

public class Station {
    private String name;
    private int numberOfLines; // 등록된 노선의 개수

    public Station(String name) {
        this.name = name;
        this.numberOfLines = 0;
    }

    public String getName() {
        return name;
    }

    public void addLine() {
        numberOfLines++;
    }

    public void removeLine() {
        numberOfLines--;
    }

    public boolean isRemovable() {
        return numberOfLines == 0;
    }
}
