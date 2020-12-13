package subway.domain.station;

public class StationCheck {

    private String stationName;

    private static final int MIN_STATION_NAME_LENGTH = 2;

    private static final String STATION_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 역이름은 2글자 이상 입력해야합니다.";

    public static boolean checkStationNameLength(String stationName) {
        if (stationName.length() < MIN_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(STATION_NAME_LENGTH_ERROR_MESSAGE);
        }
        return true;
    }
}
