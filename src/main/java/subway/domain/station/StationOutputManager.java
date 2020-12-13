package subway.domain.station;

import subway.common.GuideMessage;
import subway.common.InfoMessage;

public class StationOutputManager {

    private static final String STATION_ADD_GUIDE = "등록할 역 이름을 입력하세요.";
    private static final String STATION_DELETE_GUIDE = "삭제할 역 이름을 입력하세요.";
    private static final String STATION_ADDED = "지하철 역이 등록되었습니다.";
    private static final String STATION_DELETED = "지하철 역이 삭제되었습니다.";
    private static final String STATION_LIST = "역 목록";

    private StationOutputManager(){
    }

    public static void printAddSGuide() {
        GuideMessage.print(STATION_ADD_GUIDE);
    }

    public static void printDeleteGuide() {
        GuideMessage.print(STATION_DELETE_GUIDE);
    }

    public static void printAddedInfo() {
        InfoMessage.print(STATION_ADDED);
    }

    public static void printDeletedInfo() {
        InfoMessage.print(STATION_DELETED);
    }


    public static void printStations() {
        GuideMessage.print(STATION_LIST);
        for (Station station : StationRepository.stations()) {
            InfoMessage.print(station.getName());
        }
    }
}
