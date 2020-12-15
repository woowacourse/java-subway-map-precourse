package subway.view;

import subway.domain.Station;
import subway.domain.repositories.StationRepository;
import java.util.List;

public class StationView {
    private static final String ADD_SUCCESS_MSG = "[INFO] 지하철 역이 등록되었습니다.";
    private static final String DELETE_SUCCESS_MSG = "[INFO] 지하철 역이 삭제되었습니다.";
    private static final String ADD_REQ_MSG = "## 등록할 역 이름을 입력하세요.";
    private static final String DELETE_REQ_MSG = "## 삭제할 역 이름을 입력하세요.";
    private static final String STATION_CHECK_HEADER = "## 역 목록";

    public static void printStationAddReqMsg(){
        System.out.println();
        System.out.println(ADD_REQ_MSG);
    }

    public static void printStationAddSuccessMsg(){
        System.out.println();
        System.out.println(ADD_SUCCESS_MSG);
    }

    public static void printStationCheck(){
        System.out.println();
        System.out.println(STATION_CHECK_HEADER);
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
    }

    public static void printStationDeleteReqMsg(){
        System.out.println();
        System.out.println(DELETE_REQ_MSG);
    }
    public static void printStationDeleteSuccessMsg(){
        System.out.println();
        System.out.println(DELETE_SUCCESS_MSG);
    }
}
