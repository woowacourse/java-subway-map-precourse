package subway.domain;

public class Station {

    private static final String WHITE_SPACE = " ";
    private static final String RULE_STATION_NAME = "역";
    private static final int LAST_INDEX = 1;
    private static final int MINIMUM_NAME_LENGTH = 3;

    private final String name;

    private Station(String name) {
        validateNameLastCharacter(name);
        validateNameContainWhitepace(name);
        validateNameLength(name);
        this.name = name;
    }

    public static Station newStationWithName(String stationName) {
        return new Station(stationName);
    }

    public String getName() {
        return name;
    }

    private void validateNameLastCharacter(String name) {
        if (!name.substring(name.length() - LAST_INDEX).equals(RULE_STATION_NAME)) {
            throw new IllegalArgumentException("지하철 역 이름은 \"역\"으로 끝나야 합니다.");
        }
    }

    private void validateNameContainWhitepace(String name) {
        if (name.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException("지하철 역 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("지하철 역 이름은 2글자 이상 + \"역\"으로 이루어져야 합니다.");
        }
    }
}
