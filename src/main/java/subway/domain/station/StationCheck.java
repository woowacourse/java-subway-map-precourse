package subway.domain.station;

public class StationCheck {

    private String stationName;

    private static final int MIN_STATION_NAME_LENGTH = 2;

    private static final String STATION_LENGTH_ERROR_MESSAGE = "[ERROR] 역이름은 2글자 이상 입력해야합니다.";
    public static final String STATION_END_POINT_ERROR_MESSAGE = "[ERROR] 역 이름은 OO역으로 끝나야 합니다.";


    public static boolean checkStationNameLength(String stationName) {
        if (stationName.length() < MIN_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(STATION_LENGTH_ERROR_MESSAGE);
        }
        return true;
    }

    public static boolean checkStationNameEndPoint(String stationName) {
        if (!stationName.endsWith("역")) {
            throw new IllegalArgumentException(STATION_END_POINT_ERROR_MESSAGE);
        }
        return true;
    }
}
