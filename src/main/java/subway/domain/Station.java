package subway.domain;

public class Station {

    private String name;
    private boolean isInLine = false;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void changeStatus() {
        this.isInLine = true;
    }

    public boolean checkInLine() {
        if (this.isInLine) {
            return true;
        }
        return false;
    }
}
