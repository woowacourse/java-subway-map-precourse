package subway.domain;

public class Station {
    private static final int MINIMUM_STATION_NAME_LENGTH = 2;
    private String name;
    private int numberOfLines = 0; // 등록된 노선의 개수

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean isValidName(String name) {
        return name.length() >= MINIMUM_STATION_NAME_LENGTH;
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

    public static int getMinimumStationNameLength() {
        return MINIMUM_STATION_NAME_LENGTH;
    }
}
