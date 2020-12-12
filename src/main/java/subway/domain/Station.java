package subway.domain;

public class Station implements Node{
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equalWith(String newName) {
        return name.equals(newName);
    }
    // 추가 기능 구현
}
