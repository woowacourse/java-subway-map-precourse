package subway.domain;

public class StationFactory {
    private static final int NAME_MIN_LENGTH = 2;
    private static final String ERR_SHORT_NAME_MSG =
            String.format("[ERROR] 역의 이름은 %d글자 이상이어야 합니다.", NAME_MIN_LENGTH);
    private static final String ERR_WRONG_STATION_NAME_SUFFIX = "[ERROR] 역의 이름은 ~역 형태여야 합니다.";
    public static final String STATION = "역";

    public static Station makeStation(String name) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ERR_SHORT_NAME_MSG);
        }
        if (!name.endsWith(STATION)){
            throw new IllegalArgumentException(ERR_WRONG_STATION_NAME_SUFFIX);
        }
        return new Station(name);
    }
}
