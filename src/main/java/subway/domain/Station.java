package subway.domain;

public class Station {
    public static final String ERROR_NAME_LENGTH = "역 이름은 2자 이상이여야 합니다.";
    public static final String ERROR_NAME_CONVENTION = "역 이름의 마지막 글자는 \"역\" 이여야 합니다.";
    public static final String NAME_CONVENTION = "역";
    public static final int NAME_LENGTH_MIN = 2;

    private String name;

    public Station(String name) {
        validateNameLength(name);
        validateNameConvention(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String stationName) {
        if (stationName.length() < NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    private void validateNameConvention(String stationName) {
        if (!Character.toString(stationName.charAt(stationName.length() - 1)).equals(NAME_CONVENTION)) {
            throw new IllegalArgumentException(ERROR_NAME_CONVENTION);
        }
    }
}
