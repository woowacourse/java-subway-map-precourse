package subway.domain.station;

import subway.common.Guide;

public class StationOutputManager {

    public static final String STATION_ADD_GUIDE = "등록할 역 이름을 입력하세요.";
    public static final String STATION_DELETE_GUIDE = "삭제할 역 이름을 입력하세요.";

    public static void printStationGuide() {
        Guide.print( STATION_ADD_GUIDE);
    }

    public static void printStationDeleteGuide() {
        Guide.print(STATION_DELETE_GUIDE);
    }


}
